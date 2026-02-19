package com.sprinboot.project10_oneTomany.service.serviceimpl;

import com.sprinboot.project10_oneTomany.customexception.NoStudentFoundException;
import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Studentdto;
import com.sprinboot.project10_oneTomany.repository.Addressrepo;
import com.sprinboot.project10_oneTomany.repository.Studentrepo;
import com.sprinboot.project10_oneTomany.service.Studentservcie;
import com.sprinboot.project10_oneTomany.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.http.HttpStatus;
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
        if(studentrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no student in database", HttpStatus.NOT_FOUND.value());
        }
        return modelutility.listStudentEntityToDto(studentrepo.findAll());
    }

    @Override
    public Studentdto GetStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
            return modelutility.studentEntityToDto(byId.get());
        }
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteStudentById(Long id) {
        Optional<Student> byId = studentrepo.findById(id);
        if(byId.isPresent()){
            studentrepo.deleteById(id);
            return "deleted";
        }
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }

    @Override
    public String deleteAllStudents() {
        if(studentrepo.findAll().isEmpty()){
            throw new NoStudentFoundException("there is no student in database", HttpStatus.NOT_FOUND.value());
        }
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
        throw new NoStudentFoundException("there is no student of given id ",HttpStatus.NOT_FOUND.value());
    }
}
