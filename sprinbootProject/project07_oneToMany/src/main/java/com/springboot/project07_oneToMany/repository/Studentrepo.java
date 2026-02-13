package com.springboot.project07_oneToMany.repository;

import com.springboot.project07_oneToMany.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {


}