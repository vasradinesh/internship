package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Model.DonoationDetailsHistory;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Service.DonorDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {


    @Autowired
    private DonorDetailsService donorDetailsService;


    @GetMapping("get-donor-by-id/{id}")
    public ResponseEntity<DonorDetailsProxy> getDonorDetailsById(@PathVariable Long id){
        return new ResponseEntity<>(donorDetailsService.getDonorDetailsById(id), HttpStatus.OK);
    }

    @PostMapping("save-or-update-donor")
    public ResponseEntity<String> saveOrUpdateDonor(@Valid @RequestBody DonorDetailsProxy donorDetailsProxy){
        return new ResponseEntity<>(donorDetailsService.saveOrUpdateDonor(donorDetailsProxy),HttpStatus.OK);
    }


    @GetMapping("get-donor-history")
    public ResponseEntity<List<DonoationDetailsHistory>> getDonorHistory(){
        return new ResponseEntity<>(donorDetailsService.getDonorHistory(),HttpStatus.OK);
    }

    @PostMapping("donate")
    public ResponseEntity<String> donateBlood(@Valid @RequestBody DonationProxy donationProxy){
        donationProxy.setRemarks("unchecked blood");
        return new ResponseEntity<>(donorDetailsService.donateBlood(donationProxy),HttpStatus.OK);
    }


}
