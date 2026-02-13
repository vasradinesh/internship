package com.sprinboot.project08_oneToonebidirectional.utility;


import com.sprinboot.project08_oneToonebidirectional.domain.Address;
import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import com.sprinboot.project08_oneToonebidirectional.dto.Addressdto;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Modelutility {

    @Autowired
    private ModelMapper modelMapper;

    public Studentdto entityToDto(Student student){
        student.getAddress().setStudent(null);
        return modelMapper.map(student, Studentdto.class);
    }

    public Student dtoToEntity(Studentdto studentdto){
        return modelMapper.map(studentdto,Student.class);
    }

    public List<Studentdto> listEntityToListDto(List<Student> students){
        return students.stream().map(s->entityToDto(s)).toList();
    }

    public List<Student> listDtoToListEntity(List<Studentdto> studentdtoList){
        return studentdtoList.stream().map(s->dtoToEntity(s)).toList();
    }


//    address


    public Addressdto addressEntityToDto(Address address){
        address.getStudent().setAddress(null);
        return modelMapper.map(address, Addressdto.class);
    }

    public List<Addressdto> listaddressEntityTodto(List<Address> addressList){
        return addressList.stream().map(s->addressEntityToDto(s)).toList();
    }

    public Address addressDtoToEntity(Addressdto addressdto){
        return modelMapper.map(addressdto,Address.class);
    }

    public List<Address> listaddressDtoToEntity(List<Addressdto> addressdtoList){
        return addressdtoList.stream().map(s->addressDtoToEntity(s)).toList();
    }
}
