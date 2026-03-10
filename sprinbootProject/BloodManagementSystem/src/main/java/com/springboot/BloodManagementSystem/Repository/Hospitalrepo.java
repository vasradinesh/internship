package com.springboot.BloodManagementSystem.Repository;

import com.springboot.BloodManagementSystem.Domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hospitalrepo extends JpaRepository<Hospital,Long> {

}
