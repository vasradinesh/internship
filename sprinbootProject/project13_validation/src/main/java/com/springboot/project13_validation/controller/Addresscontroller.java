package com.springboot.project13_validation.controller;


import com.springboot.project13_validation.domain.Address;
import com.springboot.project13_validation.dto.Addressdto;
import com.springboot.project13_validation.service.Addressservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Addresscontroller {

    @Autowired
    private Addressservice addressservice;

    @PostMapping("save-address")
    public ResponseEntity<String> saveAddress(@Valid @RequestBody Addressdto addressdto){
        String msg = addressservice.saveAddress(addressdto);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("get-address-by-id/{id}")
    public Addressdto getAddressById(@PathVariable Long id){
        return addressservice.getAddressById(id);
    }

    @GetMapping("get-all-Address")
    public List<Addressdto> getAllAddress(){
        return addressservice.getAllAddress();
    }

    @DeleteMapping("delete-address-by-id/{id}")
    public String deleteAddressBYId(@PathVariable Long id){
        return addressservice.deleteAddressById(id);
    }

    @DeleteMapping("delete-all-address")
    public String deleteAllAddress(){
        return addressservice.deleteAllAddress();
    }

    @PostMapping("update-address-by-id/{id}")
    public String updateStudentById(@PathVariable Long id,@Valid @RequestBody Addressdto addressdto){
        return addressservice.updateAddressById(id,addressdto);
    }

}
