package com.bloodmangement.serviceDonor.Service.Serviceimpl;

import com.bloodmangement.serviceDonor.CustomException.NoUserFoundException;
import com.bloodmangement.serviceDonor.Domain.Donation;
import com.bloodmangement.serviceDonor.Domain.DonorDetails;
import com.bloodmangement.serviceDonor.Model.DonoationDetailsHistory;
import com.bloodmangement.serviceDonor.Model.TokenRole;
import com.bloodmangement.serviceDonor.Model.Users;
import com.bloodmangement.serviceDonor.Proxy.DonationProxy;
import com.bloodmangement.serviceDonor.Proxy.DonorDetailsProxy;
import com.bloodmangement.serviceDonor.Repository.Donationrepo;
import com.bloodmangement.serviceDonor.Repository.DonorDetailsrepo;
import com.bloodmangement.serviceDonor.Service.DonorDetailsService;
import com.bloodmangement.serviceDonor.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonorDetailsServiceImpl implements DonorDetailsService {

    @Autowired
    private DonorDetailsrepo donorDetailsrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Donationrepo donationrepo;

    @Autowired
    private RestTemplate restTemplate;



    @Override
    public DonorDetailsProxy getDonorDetailsById(Long id,String token) {

        TokenRole tokenRole = new TokenRole();
        tokenRole.setToken(token);
        tokenRole.setRole("ROLE_DONOR");

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",tokenRole,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        Optional<DonorDetails> donorDetails = donorDetailsrepo.findById(id);
        if(donorDetails.isPresent()){
            return mapper.mapper(donorDetails.get(),DonorDetailsProxy.class);
        }else {
            throw new NoUserFoundException("no donor found of given id", HttpStatus.NOT_FOUND.toString());
        }
    }

    @Override
    public String saveDonor(DonorDetailsProxy donorDetailsProxy,String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        donorDetailsProxy.setLastDonationDate(LocalDateTime.now());

        Users user = restTemplate.getForObject("http://localhost:9090/gateway/auth/get-user/" + donorDetailsProxy.getUserid(), Users.class);

        Optional<DonorDetails> byUser = donorDetailsrepo.findByUserid(user.getId());

        DonorDetails donorDetails = mapper.mapper(donorDetailsProxy, DonorDetails.class);
        donorDetails.setUserid(user.getId());

        if(!user.getRole().equals("ROLE_DONOR")) {
            throw new RuntimeException("given user id role is not DONOR so can't do donation");
        }

        if(byUser.isPresent()){
            donorDetails.setId(byUser.get().getId());
            donorDetails.setUserid(user.getId());
            donorDetailsrepo.save(donorDetails);
            return "updated";
        }

        donorDetailsrepo.save(donorDetails);
        return "saved";
    }

    @Override
    public List<DonoationDetailsHistory> getDonorHistory(String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        List<DonationProxy> list = donationrepo.findAll().stream().
                map(m -> mapper.mapper(m, DonationProxy.class)).toList();

        List<DonoationDetailsHistory> donorDetailsHistories = new ArrayList<>();

        for (DonationProxy d : list){
            donorDetailsHistories
                    .add(new DonoationDetailsHistory(d.getId(), d.getDonationDate(),d.getQuantity(),d.getRemarks()));
        }

        return donorDetailsHistories;

    }

    @Override
    public String donateBlood(DonationProxy donationProxy,String token) {

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",token,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        donationProxy.setDonationDate(LocalDateTime.now());

        Long id = donationProxy.getDonorDetails().getId();
        DonorDetails donorDetails = donorDetailsrepo.findById(id).orElseThrow(() -> new NoUserFoundException("there is no Donor found ",HttpStatus.NOT_FOUND.toString()));
        Donation donation = mapper.mapper(donationProxy, Donation.class);
        donation.setDonorDetails(donorDetails);
        return donationrepo.save(donation).toString();
    }

    @Override
    public DonationProxy getDonationById(Long id) {
        Optional<Donation> byId = donationrepo.findById(id);
        if(byId.isPresent()){
            return mapper.mapper(byId.get(), DonationProxy.class);
        }
        throw new RuntimeException("no donation found of given id");
    }

    @Override
    public String saveDonation(Donation donation) {
        donationrepo.save(donation);
        return "approved";
    }


}
