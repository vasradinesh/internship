package com.springboot.BloodManagementSystem.Repository;

import com.springboot.BloodManagementSystem.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface Userrepo extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
