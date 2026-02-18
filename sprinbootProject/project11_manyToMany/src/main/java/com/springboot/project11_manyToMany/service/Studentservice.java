package com.springboot.project11_manyToMany.service;


import com.springboot.project11_manyToMany.dto.Studentdto;

import java.util.List;

public interface Studentservice {

    public Studentdto getStudentById(Long id);
    public String saveStudent(Studentdto studentdto);
    public List<Studentdto> getAllStudent();
    public String deleteAllStudent();
    public String deleteStudentById(Long id);
    public String updateStudentById(Long id,Studentdto studentdto);


}
