package com.springboot.project11_manyToMany.repository;

import com.springboot.project11_manyToMany.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student,Long> {

}
