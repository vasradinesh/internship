package com.bloodmangement.serviceDonor.Repository;


import com.bloodmangement.serviceDonor.Domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Donationrepo extends JpaRepository<Donation,Long> {

}
