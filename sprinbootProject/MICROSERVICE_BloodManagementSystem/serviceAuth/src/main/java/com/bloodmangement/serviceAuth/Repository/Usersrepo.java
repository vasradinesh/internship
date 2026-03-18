package com.bloodmangement.serviceAuth.Repository;

import com.bloodmangement.serviceAuth.Domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Usersrepo extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
