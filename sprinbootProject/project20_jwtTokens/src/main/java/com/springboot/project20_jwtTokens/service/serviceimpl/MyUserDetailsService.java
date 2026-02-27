package com.springboot.project20_jwtTokens.service.serviceimpl;

import com.springboot.project20_jwtTokens.Entity.Student;
import com.springboot.project20_jwtTokens.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> byUsername = studentrepo.findByUsername(username);
        if (byUsername.isPresent()){
            Student student = byUsername.get();
            return User.builder().username(student.getUsername()).password(student.getPassword()).build();
        }
        throw new RuntimeException("student no found");
    }
}
