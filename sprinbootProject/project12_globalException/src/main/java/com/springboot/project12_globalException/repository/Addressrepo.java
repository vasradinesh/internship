package com.springboot.project12_globalException.repository;

import com.springboot.project12_globalException.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addressrepo extends JpaRepository<Address,Long> {
}
