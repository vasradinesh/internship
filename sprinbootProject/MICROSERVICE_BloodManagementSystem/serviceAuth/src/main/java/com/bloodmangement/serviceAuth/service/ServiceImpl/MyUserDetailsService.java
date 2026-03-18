package com.bloodmangement.serviceAuth.service.ServiceImpl;

import com.bloodmangement.serviceAuth.Domain.Users;
import com.bloodmangement.serviceAuth.Repository.Usersrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private Usersrepo userrepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> byEmail = userrepo.findByEmail(email);
        if (byEmail.isPresent()){
            Users users = byEmail.get();

            String role = users.getRole();
            String[] roles = role.split(",");

            List<SimpleGrantedAuthority> simpleGrantedAuthorities =
                    Arrays.stream(roles).map(m -> new SimpleGrantedAuthority(m)).toList();

            return User.builder()
                    .username(email)
                    .password(users.getPassword())
                    .authorities(simpleGrantedAuthorities)
                    .build();
        }else {
            throw new RuntimeException("no user found of given email " + email);
        }

    }
}