package com.sprinboot.project10_oneTomany.service;

import com.sprinboot.project10_oneTomany.domain.Student;
import com.sprinboot.project10_oneTomany.dto.Studentdto;

import java.util.List;

public interface Studentservcie {
    public String saveStudents(Studentdto studentdto);
    public List<Studentdto> getAllStudent();
    public Studentdto GetStudentById(Long id);
    public String deleteStudentById(Long id);
    public String deleteAllStudents();
    public String updateStudentBYid(Long id,Studentdto studentdto);
}
