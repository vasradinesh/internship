package com.springboot.project12_globalException.service.serviceimpl;

import com.springboot.project12_globalException.Customexception.NoAddressFound;
import com.springboot.project12_globalException.domain.Address;
import com.springboot.project12_globalException.dto.Addressdto;
import com.springboot.project12_globalException.repository.Addressrepo;
import com.springboot.project12_globalException.service.Addressservice;
import com.springboot.project12_globalException.uitility.Modeluitility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Addressimpl implements Addressservice {

    @Autowired
    private Modeluitility modeluitility;

    @Autowired
    private Addressrepo addressrepo;

    @Override
    public String saveAddress(Addressdto addressdto) {
        List<Addressdto> addressdtoList = new ArrayList<>();
        addressdtoList.add(addressdto);
        addressdto.getStudent().setAddressList(addressdtoList);
        addressrepo.save(modeluitility.addressDtoTOEntity(addressdto));
        return "saved";
    }

    @Override
    public Addressdto getAddresByid(Long id) {
        Optional<Address> addressOptional = addressrepo.findById(id);
        if(addressOptional.isPresent()){
            return modeluitility.AddressEntityToDto(addressOptional.get());
        }else {
            throw new NoAddressFound("there is no addres exist of given id ", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> addressOptional = addressrepo.findById(id);
        if(addressOptional.isPresent()){
            addressrepo.deleteById(id);
            return "deleted";
        }else {
            throw new NoAddressFound("there is no addres exist of given id ", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public String DeleteAllAddress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoAddressFound("there is no data  exist in database", HttpStatus.NOT_FOUND.value());
        }
        else {
            addressrepo.deleteAll();
            return "all address deleted";
        }
    }

    @Override
    public String updateAddressById(Long id, Addressdto addressdto) {
        List<Addressdto> list = new ArrayList<>();
        list.add(addressdto);
        addressdto.getStudent().setAddressList(list);
        Optional<Address> addressOptional = addressrepo.findById(id);
        if(addressOptional.isPresent()){
            addressrepo.save(modeluitility.addressDtoTOEntity(addressdto));
            return "updeted";
        }else {
            throw new NoAddressFound("there is no addres exist of given id ", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public List<Addressdto> getAlladdress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoAddressFound("there is no data  exist in database", HttpStatus.NOT_FOUND.value());
        }
        else {
           return modeluitility.listAddresEntityToDto(addressrepo.findAll());
        }
    }
}
