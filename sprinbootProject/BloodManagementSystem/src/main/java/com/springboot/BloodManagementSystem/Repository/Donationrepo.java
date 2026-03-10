package com.springboot.BloodManagementSystem.Repository;

import com.springboot.BloodManagementSystem.Domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Donationrepo extends JpaRepository<Donation,Long> {

}
