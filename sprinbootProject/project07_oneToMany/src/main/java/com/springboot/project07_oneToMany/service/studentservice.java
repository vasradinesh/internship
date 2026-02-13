package com.springboot.project07_oneToMany.service;

import com.springboot.project07_oneToMany.domain.Address;
import com.springboot.project07_oneToMany.domain.Student;

import java.util.List;

public interface studentservice {
    public String saveStudents(Student student);
    public List<Student> getAllStudent();
    public Student GetStudentById(Long id);
    public String deleteStudentById(Long id);
    public String deleteAllStudents();
    public String updateStudentBYid(Long id,Student student);
}
