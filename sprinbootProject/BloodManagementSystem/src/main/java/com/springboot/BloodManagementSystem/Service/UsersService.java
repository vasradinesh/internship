package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;

import java.util.List;

public interface UsersService {

    List<DonorDetailsProxy> searchBloodGroup(String bloodgroup);

    List<DonorDetailsProxy> searchDonors();

    List<HospitalProxy> getAllHospital();

}
