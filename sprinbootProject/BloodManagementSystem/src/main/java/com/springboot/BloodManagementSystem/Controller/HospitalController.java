package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/save-hospital")
    public ResponseEntity<String> saveHospital(@RequestBody HospitalProxy hospitalProxy){
        return new ResponseEntity<>(hospitalService.saveHospital(hospitalProxy), HttpStatus.CREATED);
    }

    @PostMapping("/request")
    public ResponseEntity<String> bloodRequest(@RequestBody BloodRequestProxy bloodRequestProxy){
        return new ResponseEntity<>(hospitalService.bloodRequest(bloodRequestProxy),HttpStatus.OK);
    }


}
