package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Proxy.DonorDetailsProxy;
import com.springboot.BloodManagementSystem.Proxy.HospitalProxy;
import com.springboot.BloodManagementSystem.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/search/blood/{bloodgroup}")
    public ResponseEntity<List<DonorDetailsProxy>> searchBloodGroup(@PathVariable String bloodgroup){
        return new ResponseEntity<>(usersService.searchBloodGroup(bloodgroup), HttpStatus.FOUND);
    }

    @GetMapping("/search/donors")
    public ResponseEntity<List<DonorDetailsProxy>> searchDonors(){
        return new ResponseEntity<>(usersService.searchDonors(),HttpStatus.FOUND);
    }

    @GetMapping("hospitals")
    public ResponseEntity<List<HospitalProxy>> getHospitals(){
        return new ResponseEntity<>(usersService.getAllHospital(),HttpStatus.FOUND);
    }


}
