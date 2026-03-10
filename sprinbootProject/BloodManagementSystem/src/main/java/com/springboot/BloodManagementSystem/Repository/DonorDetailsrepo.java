package com.springboot.BloodManagementSystem.Repository;

import com.springboot.BloodManagementSystem.Domain.DonorDetails;
import com.springboot.BloodManagementSystem.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonorDetailsrepo extends JpaRepository<DonorDetails,Long> {
     Optional<DonorDetails> findByUser(Users users);

     List<DonorDetails> findByBloodGroup(String bloodgroup);

}
