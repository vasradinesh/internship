package com.bloodmangement.serviceHospital.Controller;

import com.bloodmangement.serviceHospital.Model.BloodRequestHistory;
import com.bloodmangement.serviceHospital.Proxy.BloodRequestProxy;
import com.bloodmangement.serviceHospital.Proxy.HospitalProxy;
import com.bloodmangement.serviceHospital.Service.HospitalService;
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

    @PostMapping("/blood-request")
    public ResponseEntity<String> bloodRequest(@Valid @RequestBody BloodRequestProxy bloodRequestProxy){
        bloodRequestProxy.setRequestDate(LocalDateTime.now());
        bloodRequestProxy.setStatus("pending");
        return new ResponseEntity<>(hospitalService.bloodRequest(bloodRequestProxy),HttpStatus.OK);
    }

        @PostMapping("set-approved")
    public ResponseEntity<String> setApprovedRequest(@RequestBody BloodRequestProxy bloodRequestProxy){
        return new ResponseEntity<>(hospitalService.setApprovedRequest(bloodRequestProxy),HttpStatus.OK);
    }




    @GetMapping("bloodrequest/history")
    public ResponseEntity<List<BloodRequestHistory>> bloodRequestHistory(){
        return new ResponseEntity<>(hospitalService.getBloodRequestHistory(),HttpStatus.OK);
    }

    @GetMapping("get-bloodrequest/{id}")
    public ResponseEntity<BloodRequestProxy> getBloodRequest(@PathVariable Long id){
        return new ResponseEntity<>(hospitalService.getBloodRequest(id),HttpStatus.OK);
    }



}