package com.springboot.project19_springseuritycore.service.serviceimpl;

import com.springboot.project19_springseuritycore.Repository.Studentrepo;
import com.springboot.project19_springseuritycore.proxy.Studentproxy;
import com.springboot.project19_springseuritycore.service.Studentservice;
import com.springboot.project19_springseuritycore.utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Studentimpl implements Studentservice {


    @Autowired
    private Studentrepo studentrepo;

    @Autowired
    private Mapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String saveStudent(Studentproxy studentproxy) {
        studentproxy.setPassword(passwordEncoder.encode(studentproxy.getPassword()));
        return studentrepo.save(mapper.proxytToEntity(studentproxy)).toString();
    }


}
