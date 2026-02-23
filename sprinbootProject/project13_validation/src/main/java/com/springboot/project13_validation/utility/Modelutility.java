package com.springboot.project13_validation.utility;

import com.springboot.project13_validation.domain.Address;
import com.springboot.project13_validation.domain.Student;
import com.springboot.project13_validation.dto.Addressdto;
import com.springboot.project13_validation.dto.Studentdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@Component
public class Modelutility {

    @Autowired
    private ModelMapper modelMapper;

    public Student dtoToEntity(Studentdto studentdto){
        return modelMapper.map(studentdto,Student.class);
    }

    public Studentdto entityToDto(Student student){
        student.getAddressList().forEach(s->s.setStudent(null));
        return modelMapper.map(student, Studentdto.class);
    }

    public List<Student> listStudentDtoToEntity(List<Studentdto> studentdtoList){
        return studentdtoList.stream().map(s->dtoToEntity(s)).toList();
    }

    public List<Studentdto> listStudentEntity(List<Student> studentList){
        return studentList.stream().map(s->entityToDto(s)).toList();
    }

    public Addressdto addressEntityToDto(Address address){
        address.getStudent().setAddressList(null);
        return modelMapper.map(address, Addressdto.class);
    }

    public Address addressDtoToEntity(Addressdto addressdto){
        return modelMapper.map(addressdto, Address.class);
    }

    public List<Address> listAddressDtoToEntity(List<Addressdto> addressdtoList){
        return addressdtoList.stream().map(s->addressDtoToEntity(s)).toList();
    }

    public List<Addressdto> listAddressEntityToDto(List<Address> addressList){
        return addressList.stream().map(s->addressEntityToDto(s)).toList();
    }






}
