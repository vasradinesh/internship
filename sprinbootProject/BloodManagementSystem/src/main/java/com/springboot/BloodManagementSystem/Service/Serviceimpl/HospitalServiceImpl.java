package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Domain.Hospital;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.BloodRequestrepo;
import com.springboot.BloodManagementSystem.Repository.Hospitalrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.HospitalService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HospitalServiceImpl implements HospitalService {
    
    @Autowired
    private Hospitalrepo hospitalrepo;
    
    @Autowired
    private Userrepo userrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private BloodRequestrepo bloodRequestrepo;
    
    
    @Override
    public String saveHospital(HospitalProxy hospitalProxy) {

        Long id = hospitalProxy.getUsers().getId();
        Optional<Users> user = userrepo.findById(id);
        if (user.isPresent()){
            Users users = user.get();
            UsersProxy mapper1 = mapper.mapper(users, UsersProxy.class);
            hospitalProxy.setUsers(mapper1);
            hospitalrepo.save(mapper.mapper(hospitalProxy, Hospital.class));

            return hospitalProxy.toString();
        }
        throw new RuntimeException("no user of given id");
    }

    @Override
    public String bloodRequest(BloodRequestProxy bloodRequestProxy) {
        Long hospitalid = bloodRequestProxy.getHospital().getId();
        Optional<Hospital> byId = hospitalrepo.findById(hospitalid);

        if(byId.isPresent()){
            Hospital hospital = byId.get();
            HospitalProxy mapper1 = mapper.mapper(hospital, HospitalProxy.class);

            bloodRequestProxy.setHospital(mapper1);

            bloodRequestrepo.save(mapper.mapper(bloodRequestProxy, BloodRequest.class));
            return "created";
        }
        return "there is no hosptal of given id";
    }
}
