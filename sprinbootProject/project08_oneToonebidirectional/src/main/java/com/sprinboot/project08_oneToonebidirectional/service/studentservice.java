package com.sprinboot.project08_oneToonebidirectional.service;


import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;

import java.util.List;

public interface studentservice {
    public String saveStudents(Studentdto studentdto);
    public List<Studentdto> getAllStudent();
    public Studentdto findStudentByEmail(String email);
}
