package com.springboot.project19_springseuritycore.Repository;

import com.springboot.project19_springseuritycore.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Studentrepo extends JpaRepository<Student,Long> {

     Optional<Student> findByUsername(String name);

}
