package com.springboot.BloodManagementSystem.Service.Serviceimpl;


import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Repository.DonorDetailsrepo;
import com.springboot.BloodManagementSystem.Repository.Hospitalrepo;
import com.springboot.BloodManagementSystem.Service.UsersService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private DonorDetailsrepo donorDetailsrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Hospitalrepo hospitalrepo;


    @Override
    public List<DonorDetailsProxy> searchBloodGroup(String bloodgroup) {

        List<DonorDetails> byBloodGroup = donorDetailsrepo.findByBloodGroup(bloodgroup);

        if (byBloodGroup != null){
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

}
