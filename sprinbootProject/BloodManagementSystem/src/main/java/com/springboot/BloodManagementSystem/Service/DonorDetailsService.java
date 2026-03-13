package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Model.DonoationDetailsHistory;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;

import java.util.List;

public interface DonorDetailsService {

    DonorDetailsProxy getDonorDetailsById(Long id);

    String saveOrUpdateDonor(DonorDetailsProxy donorDetailsProxy);

    List<DonoationDetailsHistory> getDonorHistory();

    String donateBlood(DonationProxy donationProxy);

}
