package com.sprinboot.project08_oneToonebidirectional.service;

import com.sprinboot.project08_oneToonebidirectional.dto.Addressdto;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;

import java.util.List;

public interface Addressservice {
    public String saveAddress(Addressdto addressdto);
    public List<Addressdto> getAlladdress();
    public Addressdto findaddressById(Long id);
}
