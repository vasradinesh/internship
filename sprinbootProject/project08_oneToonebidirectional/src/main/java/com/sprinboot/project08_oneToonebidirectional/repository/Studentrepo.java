package com.sprinboot.project08_oneToonebidirectional.repository;

import com.sprinboot.project08_oneToonebidirectional.domain.Student;
import com.sprinboot.project08_oneToonebidirectional.dto.Studentdto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student,Long> {
    public Student findStudentByEmail(String email);
}
