package com.springboot.project12_globalException.service;


import com.springboot.project12_globalException.dto.Addressdto;

import java.util.List;

public interface Addressservice {

    public String saveAddress(Addressdto addressdto);
    public Addressdto getAddresByid(Long id);
    public String deleteAddressById(Long id);
    public String DeleteAllAddress();
    public String updateAddressById(Long id,Addressdto addressdto);
    public List<Addressdto> getAlladdress();

}
