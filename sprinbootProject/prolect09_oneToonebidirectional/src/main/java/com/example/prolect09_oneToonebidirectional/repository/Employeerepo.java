package com.example.prolect09_oneToonebidirectional.repository;

import com.example.prolect09_oneToonebidirectional.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {
}
