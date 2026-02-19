package com.springboot.project12_globalException.service;


import com.springboot.project12_globalException.dto.Studentdto;

import java.util.List;

public interface Studentservice  {
    public String saveStudent(Studentdto studentdto);
    public Studentdto getStudentById(Long id);
    public List<Studentdto> getAllStudent();
    public String deleteStudentById(Long id);
    public String deleteAllStudent();
    public String updateStudentById(Long id,Studentdto studentdto);
}
