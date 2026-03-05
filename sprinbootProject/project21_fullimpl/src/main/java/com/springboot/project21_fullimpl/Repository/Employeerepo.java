package com.springboot.project21_fullimpl.Repository;

import com.springboot.project21_fullimpl.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface Employeerepo extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByUserName(String username);
    void deleteByUserName(String name);
}
