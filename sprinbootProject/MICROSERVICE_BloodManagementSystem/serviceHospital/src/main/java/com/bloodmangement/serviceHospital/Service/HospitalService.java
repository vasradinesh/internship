package com.bloodmangement.serviceHospital.Service;

import com.bloodmangement.serviceHospital.Model.BloodRequestHistory;
import com.bloodmangement.serviceHospital.Proxy.BloodRequestProxy;
import com.bloodmangement.serviceHospital.Proxy.HospitalProxy;

import java.util.List;

public interface HospitalService {

    String saveHospital(HospitalProxy hospitalProxy);

    String bloodRequest(BloodRequestProxy bloodRequestProxy);

    List<BloodRequestHistory> getBloodRequestHistory();

    BloodRequestProxy getBloodRequest(Long id);

    String setApprovedRequest(BloodRequestProxy bloodRequestProxy);
}
