package com.bloodmangement.serviceHospital.Service.Serviceimpl;

import com.bloodmangement.serviceHospital.CustomException.NoUserFoundException;
import com.bloodmangement.serviceHospital.Domain.BloodRequest;
import com.bloodmangement.serviceHospital.Domain.Hospital;
import com.bloodmangement.serviceHospital.Model.BloodRequestHistory;
import com.bloodmangement.serviceHospital.Model.TokenRole;
import com.bloodmangement.serviceHospital.Proxy.BloodRequestProxy;
import com.bloodmangement.serviceHospital.Proxy.BloodStockProxy;
import com.bloodmangement.serviceHospital.Proxy.HospitalProxy;
import com.bloodmangement.serviceHospital.Proxy.Users;
import com.bloodmangement.serviceHospital.Repository.BloodRequestrepo;
import com.bloodmangement.serviceHospital.Repository.Hospitalrepo;
import com.bloodmangement.serviceHospital.Service.HospitalService;
import com.bloodmangement.serviceHospital.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private Hospitalrepo hospitalrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BloodRequestrepo bloodRequestrepo;



    @Override
    public String saveHospital(HospitalProxy hospitalProxy,String token) {

        TokenRole tokenRole = new TokenRole();
        tokenRole.setToken(token);
        tokenRole.setRole("ROLE_HOSPITAL");

        if(!restTemplate.postForObject("http://localhost:9090/gateway/auth/verify-token",tokenRole,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }


        Long id = hospitalProxy.getUserid();

        Users user = restTemplate.getForObject("http://localhost:9090/auth/get-user/" + id, Users.class);
        if (user!=null){

            if (!user.getRole().equals("ROLE_HOSPITAL")){
                throw new RuntimeException("given user role is not HOSPITAL so you can't save hospital");
            }
            hospitalrepo.save(mapper.mapper(hospitalProxy, Hospital.class));

            return hospitalProxy.toString();
        }
        throw new NoUserFoundException("no user of given id : " + id, HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public String bloodRequest(BloodRequestProxy bloodRequestProxy,String token) {

        TokenRole tokenRole = new TokenRole();
        tokenRole.setToken(token);
        tokenRole.setRole("ROLE_HOSPITAL");

        if(!restTemplate.postForObject("http://localhost:9090/auth/verify-token",tokenRole,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        Long hospitalid = bloodRequestProxy.getHospital().getId();
        Optional<Hospital> byId = hospitalrepo.findById(hospitalid);

        String reqBloodGroup = bloodRequestProxy.getBloodGroup();
        Double reqQuantity = bloodRequestProxy.getQuantity();

        BloodStockProxy bloodStock = restTemplate.getForObject("http://localhost:9090/admin/get-bloodstock/" + reqBloodGroup, BloodStockProxy.class);


            if(!(bloodStock.getUnitsAvailable()>=reqQuantity)){
                throw new RuntimeException("your requested bloodgroup units is less than bloodstock unit available");
            }

        if(byId.isPresent()){
            Hospital hospital = byId.get();
            BloodRequest mapper1 = mapper.mapper(bloodRequestProxy, BloodRequest.class);
            mapper1.setHospital(hospital);
            mapper1.getHospital().setId(hospitalid);
            bloodRequestrepo.save(mapper1);
            return "created";
        }
        throw new NoUserFoundException("there is no hosptal of given id : " + hospitalid,HttpStatus.NOT_FOUND.toString());
    }


    @Override
    public List<BloodRequestHistory> getBloodRequestHistory(String token) {

        TokenRole tokenRole = new TokenRole();
        tokenRole.setToken(token);
        tokenRole.setRole("ROLE_HOSPITAL");

        if(!restTemplate.postForObject("http://localhost:9090/auth/verify-token",tokenRole,Boolean.class)){
            throw new RuntimeException("token is not valid");
        }

        List<BloodRequestProxy> list = bloodRequestrepo.findAll().stream()
                .map(m -> mapper.mapper(m, BloodRequestProxy.class)).toList();

        List<BloodRequestHistory> bloodRequestHistories = new ArrayList<>();

        for (BloodRequestProxy b : list){
            bloodRequestHistories
                    .add(new BloodRequestHistory(b.getId(),b.getBloodGroup(),b.getQuantity(),b.getRequestDate(),b.getStatus()));
        }
        return bloodRequestHistories;
    }


    @Override
    public BloodRequestProxy getBloodRequest(Long id) {
        Optional<BloodRequest> byId = bloodRequestrepo.findById(id);

        if (byId.isPresent()){
            return mapper.mapper(byId.get(), BloodRequestProxy.class);
        }
        throw new RuntimeException("there is no blood request of given id :"+ id);

    }

    @Override
    public String setApprovedRequest(BloodRequestProxy bloodRequestProxy) {
        bloodRequestrepo.save(mapper.mapper(bloodRequestProxy, BloodRequest.class));
        return "approved";
    }
}
