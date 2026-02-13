package com.sprinboot.project08_oneToonebidirectional.service.serviceimpl;

import com.sprinboot.project08_oneToonebidirectional.domain.Address;
import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import com.sprinboot.project08_oneToonebidirectional.dto.Addressdto;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import com.sprinboot.project08_oneToonebidirectional.repository.Addressrepo;
import com.sprinboot.project08_oneToonebidirectional.service.Addressservice;
import com.sprinboot.project08_oneToonebidirectional.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Addressserviceimpl implements Addressservice {

    @Autowired
    private Modelutility modelutility;

    @Autowired
    private Addressrepo addressrepo;


    @Override
    public String saveAddress(Addressdto addressdto) {
        addressdto.getStudent().setAddress(addressdto);
        addressrepo.save(modelutility.addressDtoToEntity(addressdto));
        return "Saved Successfully";
    }

    @Override
    public List<Addressdto> getAlladdress() {
        return modelutility.listaddressEntityTodto(addressrepo.findAll());
    }

    @Override
    public Addressdto findaddressById(Long id) {
        Optional<Address> byId = addressrepo.findById(id);
        if(byId.isEmpty()){
            return new Addressdto();
        }else {
            return modelutility.addressEntityToDto(byId.get());
        }
    }
}
