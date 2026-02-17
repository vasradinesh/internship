package com.sprinboot.project10_oneTomany.repository;

import com.sprinboot.project10_oneTomany.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentrepo extends JpaRepository<Student,Long> {

}
