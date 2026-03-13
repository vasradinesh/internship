package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Model.BloodRequestHistory;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Service.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/save-hospital")
    public ResponseEntity<String> saveHospital(@Valid @RequestBody HospitalProxy hospitalProxy){
        return new ResponseEntity<>(hospitalService.saveHospital(hospitalProxy), HttpStatus.CREATED);
    }

    @PostMapping("/request")
    public ResponseEntity<String> bloodRequest(@RequestBody BloodRequestProxy bloodRequestProxy){
        bloodRequestProxy.setRequestDate(LocalDateTime.now());
        bloodRequestProxy.setStatus("pending");
        return new ResponseEntity<>(hospitalService.bloodRequest(bloodRequestProxy),HttpStatus.OK);
    }


    @GetMapping("bloodrequest/history")
    public ResponseEntity<List<BloodRequestHistory>> bloodRequestHistory(){
        return new ResponseEntity<>(hospitalService.getBloodRequestHistory(),HttpStatus.OK);
    }



}
