package com.springboot.project05.service;

import com.springboot.project05.models.Login;
import com.springboot.project05.models.Users;

public interface Userservice {

    String signUp(Users users);

    String login(Login login);
}
