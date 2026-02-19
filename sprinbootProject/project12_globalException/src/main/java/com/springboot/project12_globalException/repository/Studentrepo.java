package com.springboot.project12_globalException.repository;

import com.springboot.project12_globalException.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {
}
