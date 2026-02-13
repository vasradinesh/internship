package com.springboot.project06_oneTOone.repository;

import com.springboot.project06_oneTOone.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {


}
