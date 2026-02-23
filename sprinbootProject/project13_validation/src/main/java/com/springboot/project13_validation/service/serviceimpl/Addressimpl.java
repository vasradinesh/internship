package com.springboot.project13_validation.service.serviceimpl;

import com.springboot.project13_validation.customexception.NoStudentFoundException;
import com.springboot.project13_validation.domain.Address;
import com.springboot.project13_validation.dto.Addressdto;
import com.springboot.project13_validation.repository.Addressrepo;
import com.springboot.project13_validation.service.Addressservice;
import com.springboot.project13_validation.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Addressimpl implements Addressservice {

    @Autowired
    private Modelutility modelutility;

    @Autowired
    private Addressrepo addressrepo;


    @Override
    public String saveAddress(Addressdto addressdto) {
        addressrepo.save(modelutility.addressDtoToEntity(addressdto));
        return "saved";
    }

    @Override
    public Addressdto getAddressById(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            return modelutility.addressEntityToDto(byId.get());
        }
        throw new NoStudentFoundException("there is no address of given id", HttpStatus.NOT_FOUND.value());
    }

    @Override
    public List<Addressdto> getAllAddress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no address in database",HttpStatus.NOT_FOUND.value());
        }
        return modelutility.listAddressEntityToDto(addressrepo.findAll());
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            addressrepo.deleteById(id);
            return "deleted";
        }
        throw new NoStudentFoundException("there is no address of given id", HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteAllAddress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no address in database",HttpStatus.NOT_FOUND.value());
        }
        addressrepo.deleteAll();
        return "deleted all addresses";
    }

    @Override
    public String updateAddressById(Long id, Addressdto addressdto) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            List<Addressdto> list = new ArrayList<>();
            list.add(addressdto);
            addressdto.getStudent().setAddressList(list);
            addressrepo.save(modelutility.addressDtoToEntity(addressdto));
            return "updated";
        }
        else {
            throw new NoStudentFoundException("there is no address of given id", HttpStatus.NOT_FOUND.value());
        }
    }
}
