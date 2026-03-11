package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
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
        throw new NoUserFoundException("no user of given id of user : " + id, HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public String bloodRequest(BloodRequestProxy bloodRequestProxy) {
        Long hospitalid = bloodRequestProxy.getHospital().getId();
        Optional<Hospital> byId = hospitalrepo.findById(hospitalid);

        if(byId.isPresent()){
            Hospital hospital = byId.get();
            BloodRequest mapper1 = mapper.mapper(bloodRequestProxy, BloodRequest.class);
            mapper1.setHospital(hospital);

            bloodRequestrepo.save(mapper1);
            return "created";
        }
        throw new NoUserFoundException("there is no hosptal of given id : " + hospitalid,HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public List<BloodRequestProxy> getBloodRequestHistory() {
        return bloodRequestrepo.findAll().stream()
                .map(m->mapper.mapper(m,BloodRequestProxy.class)).toList();
    }
}
