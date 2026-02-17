package com.sprinboot.project10_oneTomany.controller;

import com.sprinboot.project10_oneTomany.dto.Addressdto;
import com.sprinboot.project10_oneTomany.service.Addressservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Addresscontroller {

    @Autowired
    private Addressservice addressservice;


    @PostMapping("save-address")
    public String saveAddress(@RequestBody Addressdto addressdto){
        return addressservice.saveAddress(addressdto);
    }

    @GetMapping("get-address-by-id/{id}")
    public Addressdto getAddressById(@PathVariable Long id){
        return addressservice.getAddresByid(id);
    }

    @GetMapping("get-all-address")
    public List<Addressdto> getAllAddress(){
        return addressservice.getAlladdress();
    }

    @PutMapping("update-address-by-id/{id}")
    public String updateById(@PathVariable Long id,@RequestBody Addressdto addressdto){
        return addressservice.updateAddressById(id,addressdto);
    }

    @DeleteMapping("delete-address-by-id/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressservice.deleteAddressById(id);
    }

    @DeleteMapping("delete-all-address")
    public String deleteAllAddress(){
        return addressservice.DeleteAllAddress();
    }

}
