package com.springboot.project14_derivedQueryMethod.service;

import com.springboot.project14_derivedQueryMethod.dto.Studentdto;
import com.springboot.project14_derivedQueryMethod.projection.StudentfirstnameAge;

import java.util.List;

public interface Studentservice {

    void insertFakeData();
    List<Studentdto> findByEmailAndLastName(String emailAddress, String lastname);
    List<Studentdto> findByAgeGreaterThan(Integer age);
    List<Studentdto> findByFirstNameContaining(String firstName);
    List<Studentdto> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
    List<Studentdto> findByAgeBetween(Integer startAge, Integer endAge);
    List<Studentdto> findByFirstNameLike(String firstName);
    List<Studentdto> findByEmailContainingIgnoreCase(String email);
    List<Studentdto> findByAgeLessThan(Integer age);
    List<Studentdto> findByMobileNoStartingWith(String mobileNo);
    List<Studentdto> findByMobileNoContaining(String mobileNo);


    //native query's

    List<Studentdto>  getByEmailOrLastName(String email,String lastname);

    List<Studentdto> getByAge(Integer age);

    List<Studentdto> getAllStudent();



    //crud

    void saveStudent(Studentdto studentdto);

    void deleteByEmail(String email);

    void updateStudentByid(Long id, Studentdto studentdto);


    //projection

    Object[] getFirstnameAndMobile();
    List<StudentfirstnameAge> getStudentandAge();



}
