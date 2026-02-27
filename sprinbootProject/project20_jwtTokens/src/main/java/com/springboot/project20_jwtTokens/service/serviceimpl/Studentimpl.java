package com.springboot.project20_jwtTokens.service.serviceimpl;

import com.springboot.project20_jwtTokens.Entity.Student;
import com.springboot.project20_jwtTokens.JWTUtility.JwtUtil;
import com.springboot.project20_jwtTokens.Model.AuthReq;
import com.springboot.project20_jwtTokens.Model.AuthResp;
import com.springboot.project20_jwtTokens.Proxy.StudentProxy;
import com.springboot.project20_jwtTokens.Utility.Mapper;
import com.springboot.project20_jwtTokens.repository.Studentrepo;
import com.springboot.project20_jwtTokens.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class Studentimpl implements Studentservice {

    @Autowired
    private Mapper mapper;

    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public String saveStudent(StudentProxy studentProxy) {
        studentProxy.setPassword(passwordEncoder.encode(studentProxy.getPassword()));
        return studentrepo.save(mapper.proxyToEntity(studentProxy)).toString();
    }

    @Override
    public StudentProxy getStudentByUsername(String name) {
        Optional<Student> byUsername = studentrepo.findByUsername(name);
        if(byUsername.isPresent()){
            return mapper.entityToProxy(byUsername.get());
        }
        return new StudentProxy();
    }




    @Override
    public AuthResp authenticateStudent(AuthReq authReq){

        AuthResp authresp = new AuthResp();

        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));

        if (authenticate.isAuthenticated()){

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getUsername());
            String jwtToken = jwtUtil.generateToken(userDetails);

            authresp.setToken(jwtToken);
            authresp.setUsername(authReq.getUsername());
        }

        return authresp;
    }




}
