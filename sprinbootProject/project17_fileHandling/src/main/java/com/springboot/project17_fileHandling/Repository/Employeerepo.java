package com.springboot.project17_fileHandling.Repository;

import com.springboot.project17_fileHandling.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
}
