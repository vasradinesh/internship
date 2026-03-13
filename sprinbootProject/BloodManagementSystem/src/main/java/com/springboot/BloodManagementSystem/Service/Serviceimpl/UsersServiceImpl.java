package com.springboot.BloodManagementSystem.Service.Serviceimpl;


import com.springboot.BloodManagementSystem.CustomException.NoUserFoundException;
import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.DonorDetailsrepo;
import com.springboot.BloodManagementSystem.Repository.Hospitalrepo;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.UsersService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private DonorDetailsrepo donorDetailsrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Hospitalrepo hospitalrepo;

    @Autowired
    private Userrepo userrepo;


    @Override
    public List<DonorDetailsProxy> searchBloodGroup(String bloodgroup) {

        List<DonorDetails> byBloodGroup = donorDetailsrepo.findByBloodGroup(bloodgroup);

        if (byBloodGroup != null && !byBloodGroup.isEmpty()){
            return byBloodGroup.stream().map(m-> mapper.mapper(m, DonorDetailsProxy.class)).toList();
        }else {
            throw new RuntimeException("no blood group found");
        }

    }

    @Override
    public List<DonorDetailsProxy> searchDonors() {
        return donorDetailsrepo.findAll().stream()
                .map(m->mapper.mapper(m,DonorDetailsProxy.class)).toList();
    }

    @Override
    public List<HospitalProxy> getAllHospital() {
        return hospitalrepo.findAll().stream()
                .map(m->mapper.mapper(m,HospitalProxy.class)).toList();
    }

    @Override
    public String updateUserByEmail(String email,UsersProxy usersProxy) {
        Optional<Users> user = userrepo.findByEmail(email);
        if(user.isPresent()){
            Users users = user.get();
            usersProxy.setId(users.getId());
            usersProxy.setPassword(users.getPassword());
            userrepo.save(mapper.mapper(usersProxy,Users.class));
            return "user updated";
        }else {
            throw new NoUserFoundException("there is no user of given email : " + email, HttpStatus.NOT_FOUND.toString());
        }
    }

    @Override
    public List<DonorDetailsProxy> searchDonorsByCity(String city) {
        return donorDetailsrepo.findAll().stream().filter(m-> Objects.equals(m.getCity(),city))
                .map(m->mapper.mapper(m, DonorDetailsProxy.class)).toList();
    }

}
