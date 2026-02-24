package com.springboot.project18_excelwork.repository;

import com.springboot.project18_excelwork.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {
}
