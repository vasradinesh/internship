package com.bloodmangement.serviceHospital.Repository;

import com.bloodmangement.serviceHospital.Domain.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestrepo extends JpaRepository<BloodRequest,Long> {

}