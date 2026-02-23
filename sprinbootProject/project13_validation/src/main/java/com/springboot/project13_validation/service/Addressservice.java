package com.springboot.project13_validation.service;

import com.springboot.project13_validation.dto.Addressdto;
import com.springboot.project13_validation.dto.Studentdto;

import java.util.List;

public interface Addressservice {

    public String saveAddress(Addressdto addressdto);
    public Addressdto getAddressById(Long id);
    public List<Addressdto> getAllAddress();
    public String deleteAddressById(Long id);
    public String deleteAllAddress();
    public String updateAddressById(Long id ,Addressdto addressdto);

}
