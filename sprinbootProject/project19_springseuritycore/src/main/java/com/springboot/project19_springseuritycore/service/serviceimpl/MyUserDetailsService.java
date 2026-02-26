package com.springboot.project19_springseuritycore.service.serviceimpl;

import com.springboot.project19_springseuritycore.Domain.Student;
import com.springboot.project19_springseuritycore.Repository.Studentrepo;
import com.springboot.project19_springseuritycore.proxy.Studentproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
