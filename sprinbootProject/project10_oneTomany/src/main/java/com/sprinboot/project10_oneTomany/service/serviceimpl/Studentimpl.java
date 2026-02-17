package com.sprinboot.project10_oneTomany.service.serviceimpl;

import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Studentdto;
import com.sprinboot.project10_oneTomany.repository.Addressrepo;
import com.sprinboot.project10_oneTomany.repository.Studentrepo;
import com.sprinboot.project10_oneTomany.service.Studentservcie;
import com.sprinboot.project10_oneTomany.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Studentimpl implements Studentservcie {


    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Modelutility modelutility;


    @Override
    public String saveStudents(Studentdto studentdto) {
        studentdto.getAddress().forEach(s->s.setStudent(studentdto));
        studentrepo.save(modelutility.studentDtoTOEntity(studentdto));
        return "saved";
    }

    @Override
    public List<Studentdto> getAllStudent() {
        return modelutility.listStudentEntityToDto(studentrepo.findAll());
    }

    @Override
    public Studentdto GetStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
            return modelutility.studentEntityToDto(byId.get());
        }
        return new Studentdto();
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
            studentrepo.deleteById(id);
            return "deleted";
        }
        return "there is no such id exist";
    }

    @Override
    public String deleteAllStudents() {
        studentrepo.deleteAll();
        return "all student deleted";
    }

    @Override
    public String updateStudentBYid(Long id, Studentdto studentdto) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
            studentdto.getAddress().forEach(s->s.setStudent(studentdto));
            studentrepo.save(modelutility.studentDtoTOEntity(studentdto));
            return "updated";
        }
        return "there is no such id exist";
    }
}
