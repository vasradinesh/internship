package com.sprinboot.project08_oneToonebidirectional.service.serviceimpl;

import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import com.sprinboot.project08_oneToonebidirectional.repository.Studentrepo;
import com.sprinboot.project08_oneToonebidirectional.service.studentservice;
import com.sprinboot.project08_oneToonebidirectional.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentserviceimpl implements studentservice {

    @Autowired
    private Modelutility modelutility;

    @Autowired
    private Studentrepo studentrepo;

    @Override
    public String saveStudents(Studentdto studentdto) {
        return studentrepo.save(modelutility.dtoToEntity(studentdto)).toString();
    }

    @Override
    public List<Studentdto> getAllStudent() {
        return modelutility.listEntityToListDto(studentrepo.findAll());
    }

    @Override
    public Studentdto findStudentByEmail(String email) {
        Student studentByEmail = studentrepo.findStudentByEmail(email);
        if(studentByEmail==null){
            return new Studentdto();
        }else {
            return modelutility.entityToDto(studentByEmail);
        }
    }
}
