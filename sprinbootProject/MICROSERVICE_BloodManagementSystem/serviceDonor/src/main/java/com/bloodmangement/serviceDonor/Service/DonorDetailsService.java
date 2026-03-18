package com.bloodmangement.serviceDonor.Service;

import com.bloodmangement.serviceDonor.Domain.Donation;
import com.bloodmangement.serviceDonor.Model.DonoationDetailsHistory;
import com.bloodmangement.serviceDonor.Proxy.DonationProxy;
import com.bloodmangement.serviceDonor.Proxy.DonorDetailsProxy;
import jakarta.validation.Valid;

import java.util.List;

public interface DonorDetailsService {


    DonorDetailsProxy getDonorDetailsById(Long id,String token);

    String saveDonor(DonorDetailsProxy donorDetailsProxy , String token);

    List<DonoationDetailsHistory> getDonorHistory(String token);

    String donateBlood(DonationProxy donationProxy,String token);


    DonationProxy getDonationById(Long id);

    String saveDonation(Donation donation);
}
