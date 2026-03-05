package com.springboot.project21_fullimpl.service.Serviceimpl;

import com.springboot.project21_fullimpl.CustomException.NoEmployeeFoundException;
import com.springboot.project21_fullimpl.Entity.Employee;
import com.springboot.project21_fullimpl.Repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyEmployeeUserDetails implements UserDetailsService {

    @Autowired
    private Employeerepo employeerepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> byUserName = employeerepo.findByUserName(username);
        if (byUserName.isEmpty()){
            throw new
                    NoEmployeeFoundException("there is no Employee of given username", HttpStatus.NOT_FOUND.toString());
        }
        Employee employee = byUserName.get();

        String role = employee.getRole();
        String[] roles = role.split(",");

        List<SimpleGrantedAuthority> simpleGrantedAuthoritieslist =
                Arrays.stream(roles).map(m -> new SimpleGrantedAuthority(m)).toList();


        return User.builder()
                .username(username)
                .password(employee.getPassword())
                .authorities(simpleGrantedAuthoritieslist)
                .build();
    }
}
