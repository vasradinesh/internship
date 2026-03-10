package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Repository.DonorDetailsrepo;
import com.springboot.BloodManagementSystem.Service.DonorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {


    @Autowired
    private DonorDetailsService donorDetailsService;


    @GetMapping("get-donor-by-id/{id}")
    public ResponseEntity<DonorDetailsProxy> getDonorDetailsById(@PathVariable Long id){
        return new ResponseEntity<>(donorDetailsService.getDonorDetailsById(id), HttpStatus.FOUND);
    }

    @PostMapping("save-or-update-donor")
    public ResponseEntity<String> saveOrUpdateDonor(@RequestBody DonorDetailsProxy donorDetailsProxy){
        return new ResponseEntity<>(donorDetailsService.saveOrUpdateDonor(donorDetailsProxy),HttpStatus.OK);
    }


    @GetMapping("get-donor-history")
    public ResponseEntity<List<DonationProxy>> getDonorHistory(){
        return new ResponseEntity<>(donorDetailsService.getDonorHistory(),HttpStatus.FOUND);
    }

    @PostMapping("donate")
    public ResponseEntity<String> donateBlood(@RequestBody DonationProxy donationProxy){
        return new ResponseEntity<>(donorDetailsService.donateBlood(donationProxy),HttpStatus.OK);
    }


}
