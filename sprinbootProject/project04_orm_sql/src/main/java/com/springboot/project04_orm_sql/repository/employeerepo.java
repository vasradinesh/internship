package com.springboot.project04_orm_sql.repository;

import com.springboot.project04_orm_sql.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeerepo extends JpaRepository<Employee, Long> {




}
