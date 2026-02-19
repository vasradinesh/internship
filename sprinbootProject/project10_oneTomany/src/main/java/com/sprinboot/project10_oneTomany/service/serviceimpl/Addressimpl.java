package com.sprinboot.project10_oneTomany.service.serviceimpl;

import com.sprinboot.project10_oneTomany.customexception.NoStudentFoundException;
import com.sprinboot.project10_oneTomany.domain.Address;
import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Addressdto;
import com.sprinboot.project10_oneTomany.repository.Addressrepo;
import com.sprinboot.project10_oneTomany.repository.Studentrepo;
import com.sprinboot.project10_oneTomany.service.Addressservice;
import com.sprinboot.project10_oneTomany.utility.Modelutility;
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
        Address address = modelutility.addressDtotoEntity(addressdto);
        addressrepo.save(address);
        return "saved";
    }

    @Override
    public Addressdto getAddresByid(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            return modelutility.addressEntityToDto(byId.get());
        }
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            addressrepo.deleteById(id);
            return "deleted";
        }
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String DeleteAllAddress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no student in database", HttpStatus.NOT_FOUND.value());
        }
        addressrepo.deleteAll();
        return "deleted";
    }

    @Override
    public String updateAddressById(Long id, Addressdto addressdto) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            addressrepo.save(modelutility.addressDtotoEntity(addressdto));
            return "updated";
        }
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public List<Addressdto> getAlladdress() {
        if(addressrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no student in database", HttpStatus.NOT_FOUND.value());
        }
        return modelutility.listAddressEntityToDto(addressrepo.findAll());
    }
}
