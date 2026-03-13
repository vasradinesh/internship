package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;

import java.util.List;

public interface UsersService {

    List<DonorDetailsProxy> searchBloodGroup(String bloodgroup);

    List<DonorDetailsProxy> searchDonors();

    List<HospitalProxy> getAllHospital();

    String updateUserByEmail(String email,UsersProxy usersProxy);

    List<DonorDetailsProxy> searchDonorsByCity(String city);

}
