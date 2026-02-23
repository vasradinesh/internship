package com.springboot.project13_validation.repository;

import com.springboot.project13_validation.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addressrepo extends JpaRepository<Address,Long> {
}
