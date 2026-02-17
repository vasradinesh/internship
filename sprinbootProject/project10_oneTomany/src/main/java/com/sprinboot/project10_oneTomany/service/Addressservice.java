package com.sprinboot.project10_oneTomany.service;

import com.sprinboot.project10_oneTomany.dto.Addressdto;

import java.util.List;

public interface Addressservice {

    public String saveAddress(Addressdto addressdto);
    public Addressdto getAddresByid(Long id);
    public String deleteAddressById(Long id);
    public String DeleteAllAddress();
    public String updateAddressById(Long id,Addressdto addressdto);
    public List<Addressdto> getAlladdress();
}
