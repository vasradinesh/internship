package com.springboot.project14_derivedQueryMethod.controller;


import com.springboot.project14_derivedQueryMethod.domain.Student;
import com.springboot.project14_derivedQueryMethod.dto.Studentdto;
import com.springboot.project14_derivedQueryMethod.projection.StudentfirstnameAge;
import com.springboot.project14_derivedQueryMethod.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;

@RestController
public class Studentcontroller {

    @Autowired
    public Studentservice studentservice;


    @GetMapping("savedata")
    public void saveData(){
        studentservice.insertFakeData();
    }

    @GetMapping("get-by-email-and-lastname/{email}/{lastname}")
    public List<Studentdto> findByEmailAddressAndLastname(@PathVariable String email,@PathVariable String lastname){
        return studentservice.findByEmailAndLastName(email,lastname);
    }

    @GetMapping("get-by-age-greater-than/{age}")
    public List<Studentdto> findByAgeGreaterThan(@PathVariable Integer age){
        return studentservice.findByAgeGreaterThan(age);
    }

    @GetMapping("get-student-contain-firstname/{firstname}")
    public List<Studentdto> findByFirstNameContaining(@PathVariable String firstname){
        return studentservice.findByFirstNameContaining(firstname);
    }

    @GetMapping("get-student-contain-firstname-or-lastname/{firstname}/{lastname}")
    public List<Studentdto> findByFirstNameContainingOrLastNameContaining(@PathVariable String firstname,@PathVariable String lastname){
        return studentservice.findByFirstNameContainingOrLastNameContaining(firstname,lastname);
    }

    @GetMapping("get-age-between/{startage}/{endage}")
    public List<Studentdto> findByAgeBetween(@PathVariable Integer startage,@PathVariable Integer endage){
        return studentservice.findByAgeBetween(startage,endage);
    }

    @GetMapping("get-by-firstname-like/{firstname}")
    public List<Studentdto> findByFirstNameLike(@PathVariable String firstname){
        return studentservice.findByFirstNameLike(firstname);
    }

    @GetMapping("get-email-contain/{email}")
    public List<Studentdto> findByEmailContainingIgnoreCase(@PathVariable String email) {
        return studentservice.findByEmailContainingIgnoreCase(email);
    }

    @GetMapping("get-age-lessthan/{age}")
    public List<Studentdto> findByAgeLessThan(@PathVariable Integer age) {
        return studentservice.findByAgeLessThan(age);
    }

    @GetMapping("get-mobileno-startwith")
    public List<Studentdto> findByMobileNoStartingWith(@RequestParam String mobileNo) {
        return studentservice.findByMobileNoStartingWith(mobileNo);
    }

    @GetMapping("get-mobileno-containing/{mobileNo}")
    public List<Studentdto> findByMobileNoContaining(@PathVariable String mobileNo) {
        return studentservice.findByMobileNoContaining(mobileNo);
    }

    @GetMapping("get-by-email-or-lastname/{email}/{lastName}")
    public List<Studentdto> getByEmailOrLastname(@PathVariable String email,@PathVariable String lastName){
        return studentservice.getByEmailOrLastName(email,lastName);
    }

    @GetMapping("get-by-age/{age}")
    public List<Studentdto> getByAge(@PathVariable Integer age){
        return studentservice.getByAge(age);
    }

    @GetMapping("get-all-student")
    public List<Studentdto> getAllStudent(){
        return studentservice.getAllStudent();
    }

    //crud


    @DeleteMapping("delete-student-by-id/{email}")
    public void deleteStudentById(@PathVariable String email){
        studentservice.deleteByEmail(email);
    }

    @PostMapping("update-student-by-id/{id}")
    public void updateStudentById(@PathVariable Long id ,@RequestBody Studentdto studentdto){
        studentservice.updateStudentByid(id,studentdto);
    }

    @PostMapping("save-student")
    public void saveStudent(@RequestBody Studentdto studentdto){
        studentservice.saveStudent(studentdto);
    }

    //projection

    @GetMapping("get-firstname-and-age")
    public List<StudentfirstnameAge> getStudentandAge(){
        return studentservice.getStudentandAge();
    }

    @GetMapping("get-Studentname-and-mobile")
    public Object[] getStudentnameAndMobile(){
        return studentservice.getFirstnameAndMobile();
    }

}
