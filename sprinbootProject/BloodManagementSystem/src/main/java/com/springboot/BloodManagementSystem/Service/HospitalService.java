package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;

public interface HospitalService {

    String saveHospital(HospitalProxy hospitalProxy);

    String bloodRequest(BloodRequestProxy bloodRequestProxy);

}
