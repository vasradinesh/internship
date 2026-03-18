package com.bloodmangement.serviceDonor.Repository;

import com.bloodmangement.serviceDonor.Domain.DonorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonorDetailsrepo extends JpaRepository<DonorDetails,Long> {
//    Optional<DonorDetails> findByUser(Users users);
//
//    List<DonorDetails> findByBloodGroup(String bloodgroup);

    Optional<DonorDetails> findByUserid(Long id);

}

