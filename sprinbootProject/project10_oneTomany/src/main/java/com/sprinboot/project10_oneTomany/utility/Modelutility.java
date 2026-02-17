package com.sprinboot.project10_oneTomany.utility;


import com.sprinboot.project10_oneTomany.domain.Address;
import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Addressdto;
import com.sprinboot.project10_oneTomany.dto.Studentdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Modelutility {

    @Autowired
    private ModelMapper modelMapper;

    public Studentdto studentEntityToDto(Student student){
        student.getAddress().forEach(s->s.setStudent(null));
        return modelMapper.map(student, Studentdto.class);
    }

    public Student studentDtoTOEntity(Studentdto studentdto){
        return modelMapper.map(studentdto,Student.class);
    }

    public List<Studentdto> listStudentEntityToDto(List<Student> studentList){
        return studentList.stream().map(s->studentEntityToDto(s)).toList();
    }

    public List<Student> listStudentDtoTOEntity(List<Studentdto> studentdtoList){
        return studentdtoList.stream().map(s->studentDtoTOEntity(s)).toList();
    }

    //Address

    public Addressdto addressEntityToDto(Address address){
        address.getStudent().setAddress(null);
        return modelMapper.map(address,Addressdto.class);
    }

    public Address addressDtotoEntity(Addressdto addressdto){
        return modelMapper.map(addressdto,Address.class);
    }

    public List<Address> listAddressDtotoEntity(List<Addressdto> addressdtoList){
        return addressdtoList.stream().map(s->addressDtotoEntity(s)).toList();
    }

    public List<Addressdto> listAddressEntityToDto(List<Address> addressList){
        return addressList.stream().map(s->addressEntityToDto(s)).toList();
    }

}
