package com.springboot.BloodManagementSystem.Repository;

import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Proxy.BloodRequestProxy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestrepo extends JpaRepository<BloodRequest,Long> {

}
