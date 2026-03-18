package com.bloodmangement.serviceAdmin.Repository;

import com.bloodmangement.serviceAdmin.Domain.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BloodStockrepo extends JpaRepository<BloodStock,Long> {

    Optional<BloodStock> findByBloodGroup(String bloodGroup);

}
