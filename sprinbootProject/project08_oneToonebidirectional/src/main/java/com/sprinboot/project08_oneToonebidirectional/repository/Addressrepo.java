package com.sprinboot.project08_oneToonebidirectional.repository;

import com.sprinboot.project08_oneToonebidirectional.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addressrepo extends JpaRepository<Address , Long> {

}
