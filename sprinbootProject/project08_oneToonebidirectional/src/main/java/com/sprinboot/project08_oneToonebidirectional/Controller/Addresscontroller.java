package com.sprinboot.project08_oneToonebidirectional.Controller;


import com.sprinboot.project08_oneToonebidirectional.dto.Addressdto;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import com.sprinboot.project08_oneToonebidirectional.service.Addressservice;
import com.sprinboot.project08_oneToonebidirectional.service.studentservice;
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

    @GetMapping("get-all-address")
    public List<Addressdto> getAllAddress(){
        return addressservice.getAlladdress();
    }

    @GetMapping("get-address-by-id/{id}")
    public Addressdto getAddressById(@PathVariable Long id){
        return addressservice.findaddressById(id);
    }

}
