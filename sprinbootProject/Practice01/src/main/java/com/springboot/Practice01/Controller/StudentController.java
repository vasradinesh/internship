package com.springboot.Practice01.Controller;

import com.springboot.Practice01.Models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {
    HashSet<Student> setOfStudents = new HashSet<>();

    @GetMapping("/save_student/{id}/{name}/{address}/{pincode}")
    public String saveStudents(@PathVariable int id,@PathVariable String name,@PathVariable String address,@PathVariable String pincode){

        Optional<Student> first = setOfStudents.stream().filter(s -> s.getId() == id).findFirst();
        if(first.isEmpty()){
            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setAddres(address);
            s.setPincode(pincode);
            setOfStudents.add(s);
            return "student details added successfully";
        }else {
            return "student id-" + id+ " data is already available ";
        }
    }

    @GetMapping("getAllStudents")
    public Set<Student> getAllStudents(){
        return setOfStudents;
    }

    @GetMapping("/get_studentBy_id/{id}")
    public Student get_studentBy_id(@PathVariable Integer id){

        Student student = setOfStudents.stream().filter(s -> s.getId() == id).findFirst().orElse(new Student(0, null, null, null));
        return student;
    }

    @GetMapping("/delete_studentBy_id/{id}")
    public String delete_studentBy_id(@PathVariable Integer id){

        boolean b = setOfStudents.removeIf(s -> s.getId() == id);
        if (b){
            return "details of " +id +"is successfully removed";
        }
        return "there is no " + id+" related data";
    }

    @GetMapping("/update_Students_details/{id}/{name}/{address}/{pincode}")
    public String UpdateStudentsDetails(@PathVariable Integer id,@PathVariable String name,@PathVariable String address,@PathVariable String pincode){
        Optional<Student> first = setOfStudents.stream().filter(s -> s.getId() == id).findFirst();
        if (first.isPresent()){
            Student student = first.get();
            student.setName(name);
            student.setAddres(address);
            student.setPincode(pincode);

            return "details is successfully updated";
        }else {
            return "details is not available that you want to update";
        }
    }



}
