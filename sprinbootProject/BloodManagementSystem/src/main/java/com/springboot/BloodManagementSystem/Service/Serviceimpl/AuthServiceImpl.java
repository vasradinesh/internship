package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.Domain.Users;
import com.springboot.BloodManagementSystem.JwtUtility.JwtUtil;
import com.springboot.BloodManagementSystem.Model.AuthReq;
import com.springboot.BloodManagementSystem.Model.AuthResp;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Repository.Userrepo;
import com.springboot.BloodManagementSystem.Service.AuthService;
import com.springboot.BloodManagementSystem.Utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    private Userrepo userrepo;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private Mapper mapper;

    private Map<String,String> otpStorage = new HashMap<>();

    @Override
    public String register(UsersProxy usersProxy) {
        Optional<Users> byEmail = userrepo.findByEmail(usersProxy.getEmail());
        if(byEmail.isEmpty()){
            userrepo.save(mapper.mapper(usersProxy,Users.class));
        }else {
            throw new RuntimeException("not ok");
        }
        return "saved";
    }

    @Override
    public AuthResp login(AuthReq authReq) {

        UsernamePasswordAuthenticationToken  authenticationToken =
                new UsernamePasswordAuthenticationToken(authReq.getEmail(),authReq.getPassword());

        Authentication authentication = manager.authenticate(authenticationToken);

        if(authentication.isAuthenticated()){

            UserDetails userDetails = myUserDetailsService.loadUserByUsername(authReq.getEmail());

            String jwttoken = jwtUtil.generateToken(userDetails);

            return AuthResp.builder().email(authReq.getEmail())
                    .token(jwttoken).build();
        }
        throw new RuntimeException("sorry");
    }

    private String genrateOtp(){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

        return String.valueOf(otp);
    }


    @Override
    public String sendOtp(String email) {
        Optional<Users> user = userrepo.findByEmail(email);
        if (user.isEmpty()){
            throw new RuntimeException("there is no user of given email");
        }else {
            String otp = genrateOtp();
            otpStorage.put(email,otp);
            return otp;
        }
    }

    @Override
    public String verifyOtp(String email, String otp) {
        String storageotp = otpStorage.get(email);
        if(storageotp==null && !storageotp.equals(otp)){
            throw new RuntimeException("invalid otp");
        }else {
            return "correct otp";
        }
    }

    @Override
    public String resetPassword(String email, String newPassword) {
        Optional<Users> optionalUser = userrepo.findByEmail(email);

        if (optionalUser.isEmpty()){
            throw new RuntimeException("no user found");
        }else {
            Users user = optionalUser.get();
            user.setPassword(newPassword);
            userrepo.save(user);
            otpStorage.remove(email);
            return "succesfully updated";
        }
    }
}
