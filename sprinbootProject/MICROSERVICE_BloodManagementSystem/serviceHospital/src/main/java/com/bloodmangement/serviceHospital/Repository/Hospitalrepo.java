package com.bloodmangement.serviceHospital.Repository;

import com.bloodmangement.serviceHospital.Domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hospitalrepo extends JpaRepository<Hospital,Long> {

}
