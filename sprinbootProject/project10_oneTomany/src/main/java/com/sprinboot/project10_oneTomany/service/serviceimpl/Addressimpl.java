package com.sprinboot.project10_oneTomany.service.serviceimpl;

import com.sprinboot.project10_oneTomany.domain.Address;
import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Addressdto;
import com.sprinboot.project10_oneTomany.repository.Addressrepo;
import com.sprinboot.project10_oneTomany.repository.Studentrepo;
import com.sprinboot.project10_oneTomany.service.Addressservice;
import com.sprinboot.project10_oneTomany.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new Addressdto();
    }

    @Override
    public String deleteAddressById(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            addressrepo.deleteById(id);
            return "deleted";
        }
        return "there is no such id exist";
    }

    @Override
    public String DeleteAllAddress() {
        addressrepo.deleteAll();
        return "all address deleted";
    }

    @Override
    public String updateAddressById(Long id, Addressdto addressdto) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isPresent()){
            addressrepo.save(modelutility.addressDtotoEntity(addressdto));
            return "updated";
        }
        return "there is no such id Exist";
    }

    @Override
    public List<Addressdto> getAlladdress() {
        return modelutility.listAddressEntityToDto(addressrepo.findAll());
    }
}
