package com.springboot.project05.Repository;

import com.springboot.project05.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Userrepo extends JpaRepository<Users,Long> {
    public Optional<Users> findByEmail(String email);
}
