package com.sprinboot.project10_oneTomany.repository;

import com.sprinboot.project10_oneTomany.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addressrepo extends JpaRepository<Address,Long> {

}
