package com.springboot.project16_imageProcessing.Repository;

import com.springboot.project16_imageProcessing.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {

}
