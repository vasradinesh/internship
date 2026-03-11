package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
import com.springboot.BloodManagementSystem.Domain.Donation;
import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Repository.Donationrepo;
import com.springboot.BloodManagementSystem.Repository.DonorDetailsrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.DonorDetailsService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class DonorDetailsServiceImpl implements DonorDetailsService {

    @Autowired
    private Donationrepo donationrepo;

    @Autowired
    private DonorDetailsrepo donorDetailsrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Userrepo userrepo;


    @Override
    public DonorDetailsProxy getDonorDetailsById(Long id) {
        Optional<DonorDetails> donorDetails = donorDetailsrepo.findById(id);
        if(donorDetails.isPresent()){
            return mapper.mapper(donorDetails.get(),DonorDetailsProxy.class);
        }else {
            throw new NoUserFoundException("no donor found of given id", HttpStatus.NOT_FOUND.toString());
        }
    }

    @Override
    public String saveOrUpdateDonor(DonorDetailsProxy donorDetailsProxy) {
        donorDetailsProxy.setLastDonationDate(LocalDateTime.now());

        Long userId = donorDetailsProxy.getUser().getId();

        Users user = userrepo.findById(userId).orElseThrow(() -> new NoUserFoundException("User not found of given id : " + userId,HttpStatus.NOT_FOUND.toString()));

        Optional<DonorDetails> byUser = donorDetailsrepo.findByUser(user);

        DonorDetails donorDetails = mapper.mapper(donorDetailsProxy, DonorDetails.class);
        donorDetails.setUser(user);

        if(byUser.isPresent()){
            donorDetails.setId(byUser.get().getId());
            donorDetailsrepo.save(donorDetails);
            return "updated";
        }

        donorDetailsrepo.save(donorDetails);
        return "saved";
    }

    @Override
    public List<DonationProxy> getDonorHistory() {
        return donationrepo.findAll().stream().map(m->mapper.mapper(m,DonationProxy.class)).toList();
    }

    @Override
    public String donateBlood(DonationProxy donationProxy) {

        donationProxy.setDonationDate(LocalDateTime.now());

        Long id = donationProxy.getDonorDetails().getId();
        DonorDetails donorDetails = donorDetailsrepo.findById(id).orElseThrow(() -> new NoUserFoundException("there is no Donor found ",HttpStatus.NOT_FOUND.toString()));
        Donation donation = mapper.mapper(donationProxy, Donation.class);
        donation.setDonorDetails(donorDetails);
        return donationrepo.save(donation).toString();
    }
}
