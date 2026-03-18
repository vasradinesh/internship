package com.bloodmangement.serviceAuth.service;

import com.bloodmangement.serviceAuth.Domain.Users;
import com.bloodmangement.serviceAuth.Model.AuthReq;
import com.bloodmangement.serviceAuth.Model.AuthResp;
import com.bloodmangement.serviceAuth.Model.TokenRole;
import com.bloodmangement.serviceAuth.Proxy.UsersProxy;

import java.util.List;

public interface AuthService {

    String register(UsersProxy usersProxy);

    AuthResp login(AuthReq authReq);

    String sendOtp(String email);

    String verifyOtp(String email,String otp);

    String resetPassword(String email,String newPassword);

    Boolean verifyToken(TokenRole token);

    Users getUser(Long id);

    List<UsersProxy> getAllUsers();
}
