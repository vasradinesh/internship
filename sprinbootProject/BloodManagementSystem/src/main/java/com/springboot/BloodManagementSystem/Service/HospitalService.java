package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Model.BloodRequestHistory;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;

import java.util.List;

public interface HospitalService {

    String saveHospital(HospitalProxy hospitalProxy);

    String bloodRequest(BloodRequestProxy bloodRequestProxy);

    List<BloodRequestHistory> getBloodRequestHistory();

}
