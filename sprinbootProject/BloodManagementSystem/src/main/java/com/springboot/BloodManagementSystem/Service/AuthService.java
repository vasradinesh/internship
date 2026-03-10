package com.springboot.BloodManagementSystem.Service;

import com.springboot.BloodManagementSystem.Model.AuthReq;
import com.springboot.BloodManagementSystem.Model.AuthResp;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;

public interface AuthService {


    String register(UsersProxy usersProxy);

    AuthResp login(AuthReq authReq);

    String sendOtp(String email);

    String verifyOtp(String email,String otp);

    String resetPassword(String email,String newPassword);

}
