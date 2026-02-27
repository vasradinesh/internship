package com.springboot.project20_jwtTokens.repository;


import com.springboot.project20_jwtTokens.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {

    Optional<Student> findByUsername(String name);

}
