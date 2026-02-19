package com.springboot.project12_globalException.controller;

import com.springboot.project12_globalException.dto.Addressdto;
import com.springboot.project12_globalException.dto.Studentdto;
import com.springboot.project12_globalException.service.Addressservice;
import com.springboot.project12_globalException.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Addresscontroller {

    @Autowired
    private Addressservice addressservice;

    @PostMapping("save-address")
    public ResponseEntity<String> saveAddress(@RequestBody Addressdto addressdto){
        String msg = addressservice.saveAddress(addressdto);

        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }


    @GetMapping("get-address-by-id/{id}")
    public Addressdto getAddressById(@PathVariable Long id){
        return addressservice.getAddresByid(id);
    }

    @GetMapping("get-all-Address")
    public List<Addressdto> getAllAddress(){
        return addressservice.getAlladdress();
    }

    @DeleteMapping("delete-address-by-id/{id}")
    public String deleteAddressBYId(@PathVariable Long id){
        return addressservice.deleteAddressById(id);
    }

    @DeleteMapping("delete-all-address")
    public String deleteAllAddress(){
        return addressservice.DeleteAllAddress();
    }

    @PostMapping("update-address-by-id/{id}")
    public String updateStudentById(@PathVariable Long id,@RequestBody Addressdto addressdto){
        return addressservice.updateAddressById(id,addressdto);
    }
}
