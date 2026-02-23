package com.springboot.project14_derivedQueryMethod.service.serviceimpl;

import com.github.javafaker.Faker;
import com.springboot.project14_derivedQueryMethod.customexception.NoStudentFoundException;
import com.springboot.project14_derivedQueryMethod.dto.Studentdto;
import com.springboot.project14_derivedQueryMethod.helper.Modelmapper;
import com.springboot.project14_derivedQueryMethod.projection.StudentfirstnameAge;
import com.springboot.project14_derivedQueryMethod.repository.Studentrepo;
import com.springboot.project14_derivedQueryMethod.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentimpl implements Studentservice {

    @Autowired
    private Faker faker;

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Modelmapper modelmapper;


    @Override
    public void insertFakeData() {
        for (int i = 1;i<=100;i++){
            Studentdto student = new Studentdto();
            student.setFirstName(faker.name().firstName());
            student.setAge(faker.number().numberBetween(1,35));
            student.setLastName(faker.name().lastName());
            student.setEmail(faker.internet().safeEmailAddress());
            student.setMobileNo(faker.phoneNumber().phoneNumber());

            studentrepo.save(modelmapper.dtoToEntity(student));
        }
    }

    public List<Studentdto> findByEmailAndLastName(String emailAddress, String lastname){
        System.out.println(emailAddress+"  "+lastname);
        if(studentrepo.findByEmailAndLastName(emailAddress,lastname).isEmpty()){
            throw new NoStudentFoundException("there is no student found of given email : "+emailAddress+ " and lastname : "+ lastname, HttpStatus.NOT_FOUND.value());
        }
        return modelmapper.listStudentEntity(studentrepo.findByEmailAndLastName(emailAddress,lastname));
    }

    @Override
    public List<Studentdto> findByAgeGreaterThan(Integer age) {
        if(studentrepo.findByAgeGreaterThan(age).isEmpty()){
            throw new NoStudentFoundException("there is no student greter than age : " +age,HttpStatus.NOT_FOUND.value());
        }
        return modelmapper.listStudentEntity(studentrepo.findByAgeGreaterThan(age));
    }

    @Override
    public List<Studentdto> findByFirstNameContaining(String firstName) {
        if(studentrepo.findByFirstNameContaining(firstName).isEmpty()){
            throw new NoStudentFoundException("there is no student that name contain  : "+ firstName,HttpStatus.NOT_FOUND.value());
        }
        return modelmapper.listStudentEntity(studentrepo.findByFirstNameContaining(firstName));
    }

    @Override
    public List<Studentdto> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName) {
        if (studentrepo.findByFirstNameContainingOrLastNameContaining(firstName,lastName).isEmpty()){
            throw new NoStudentFoundException("there is no student that conatin : " +firstName+ " in there first name or : "+ lastName+" in last name",HttpStatus.NOT_FOUND.value());
        }
        return modelmapper.listStudentEntity(studentrepo.findByFirstNameContainingOrLastNameContaining(firstName,lastName));
    }

    @Override
    public List<Studentdto> findByAgeBetween(Integer startAge, Integer endAge) {
        return modelmapper.listStudentEntity(studentrepo.findByAgeBetween(startAge,endAge));
    }

    @Override
    public List<Studentdto> findByFirstNameLike(String firstName) {
        return modelmapper.listStudentEntity(studentrepo.findByFirstNameLike(firstName));
    }

    @Override
    public List<Studentdto> findByEmailContainingIgnoreCase(String email) {
        return modelmapper.listStudentEntity(studentrepo.findByEmailContainingIgnoreCase(email));
    }

    @Override
    public List<Studentdto> findByAgeLessThan(Integer age) {
        return modelmapper.listStudentEntity(studentrepo.findByAgeLessThan(age));
    }

    @Override
    public List<Studentdto> findByMobileNoStartingWith(String mobileNo) {
        return modelmapper.listStudentEntity(studentrepo.findByMobileNoStartingWith(mobileNo));
    }

    @Override
    public List<Studentdto> findByMobileNoContaining(String mobileNo) {
        return modelmapper.listStudentEntity(studentrepo.findByMobileNoContaining(mobileNo));
    }


    @Override
    public List<Studentdto> getByEmailOrLastName(String email, String lastname) {
        return modelmapper.listStudentEntity(studentrepo.findByEmailOrLastName(email,lastname));
    }

    @Override
    public List<Studentdto> getByAge(Integer age) {
        return modelmapper.listStudentEntity(studentrepo.getByAge(age));
    }

    @Override
    public List<Studentdto> getAllStudent() {
        return modelmapper.listStudentEntity(studentrepo.getAllStudent());
    }

    @Override
    public void saveStudent(Studentdto studentdto) {
        studentrepo.saveStudent(studentdto.getFirstName(),studentdto.getLastName(),studentdto.getAge(),studentdto.getEmail(),studentdto.getMobileNo());
    }

    @Override
    public void deleteByEmail(String email) {
        studentrepo.deleteByEmail(email);
    }

    @Override
    public void updateStudentByid(Long id, Studentdto studentdto) {
        studentrepo.updateStudentByid(id,studentdto.getEmail(),studentdto.getLastName(),studentdto.getAge(),studentdto.getFirstName());
    }

    @Override
    public Object[] getFirstnameAndMobile() {
       return studentrepo.getFirstnameAndMobile();
    }

    @Override
    public List<StudentfirstnameAge> getStudentandAge() {
        return studentrepo.getStudentandAge();
    }

}
