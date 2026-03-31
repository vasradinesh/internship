package com.springboot.project05.service.serviceimpl;

import com.springboot.project05.Repository.Userrepo;
import com.springboot.project05.models.Login;
import com.springboot.project05.models.Users;
import com.springboot.project05.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userimpl implements Userservice {

    @Autowired
    private Userrepo userrepo;

    @Override
    public String signUp(Users users) {
        userrepo.save(users);
        return "created";
    }

    @Override
    public String login(Login login) {
       return "login";
    }
}
