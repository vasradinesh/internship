package com.bloodmangement.serviceDonor.Controller;


import com.bloodmangement.serviceDonor.Domain.Donation;
import com.bloodmangement.serviceDonor.Model.DonoationDetailsHistory;
import com.bloodmangement.serviceDonor.Proxy.DonationProxy;
import com.bloodmangement.serviceDonor.Proxy.DonorDetailsProxy;
import com.bloodmangement.serviceDonor.Service.DonorDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.PATCH;
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
    public ResponseEntity<DonorDetailsProxy> getDonorDetailsById(@PathVariable Long id, HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(donorDetailsService.getDonorDetailsById(id,authtoken), HttpStatus.OK);
    }

    @PostMapping("save-donor")
    public ResponseEntity<String> saveOrUpdateDonor(@Valid @RequestBody DonorDetailsProxy donorDetailsProxy, HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");

        System.out.println(authtoken);

        return new ResponseEntity<>(donorDetailsService.saveDonor(donorDetailsProxy,authtoken),HttpStatus.OK);
    }


    @GetMapping("get-donor-history")
    public ResponseEntity<List<DonoationDetailsHistory>> getDonorHistory(HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(donorDetailsService.getDonorHistory(authtoken),HttpStatus.OK);
    }

    @PostMapping("donate")
    public ResponseEntity<String> donateBlood(@Valid @RequestBody DonationProxy donationProxy,HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        donationProxy.setRemarks("unchecked blood");
        return new ResponseEntity<>(donorDetailsService.donateBlood(donationProxy,authtoken),HttpStatus.OK);
    }

    @GetMapping("get-donation/{id}")
    public ResponseEntity<DonationProxy> getDonationById(@PathVariable Long id){
        return new ResponseEntity<>(donorDetailsService.getDonationById(id),HttpStatus.OK);
    }

    @PostMapping("save-donation")
    public ResponseEntity<String> saveDonation(@RequestBody Donation donation){
        return new ResponseEntity<>(donorDetailsService.saveDonation(donation),HttpStatus.OK);
    }




}
