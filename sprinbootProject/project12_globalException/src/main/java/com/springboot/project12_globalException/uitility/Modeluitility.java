package com.springboot.project12_globalException.uitility;

import com.springboot.project12_globalException.domain.Address;
import com.springboot.project12_globalException.domain.Student;
import com.springboot.project12_globalException.dto.Addressdto;
import com.springboot.project12_globalException.dto.Studentdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Modeluitility {

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

    public Address addressDtoTOEntity(Addressdto addressdto){
        return modelMapper.map(addressdto,Address.class);
    }

    public Addressdto AddressEntityToDto(Address address){
        address.getStudent().setAddressList(null);
        return modelMapper.map(address,Addressdto.class);
    }

    public List<Address> listAddressDtoToEntity(List<Addressdto> addressdtoList){
        return addressdtoList.stream().map(s->addressDtoTOEntity(s)).toList();
    }

    public List<Addressdto> listAddresEntityToDto(List<Address> addressList){
        return addressList.stream().map(s->AddressEntityToDto(s)).toList();
    }

}
