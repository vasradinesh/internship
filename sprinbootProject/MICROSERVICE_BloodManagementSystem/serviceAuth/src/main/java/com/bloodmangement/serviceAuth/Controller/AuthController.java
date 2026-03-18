package com.bloodmangement.serviceAuth.Controller;

import com.bloodmangement.serviceAuth.Domain.Users;
import com.bloodmangement.serviceAuth.Model.*;
import com.bloodmangement.serviceAuth.Proxy.UsersProxy;
import com.bloodmangement.serviceAuth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UsersProxy usersProxy){
        usersProxy.setPassword(passwordEncoder.encode(usersProxy.getPassword()));
        return new ResponseEntity<>(authService.register(usersProxy), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResp> login(@Valid @RequestBody AuthReq authReq){
        return new ResponseEntity<>(authService.login(authReq),HttpStatus.OK);
    }


    @GetMapping("/forget-password/{email}")
    public ResponseEntity<String> forgetPassword(@PathVariable String email){
        return new ResponseEntity<>(authService.sendOtp(email),HttpStatus.OK );
    }


    @PostMapping("/verifyotp")
    public ResponseEntity<String> verifyOtp(@Valid @RequestBody OtpVerificationReq otpVerificationReq){
        return new ResponseEntity<>(authService.
                verifyOtp(otpVerificationReq.getEmail(),otpVerificationReq.getOtp()),HttpStatus.OK);
    }

    @PostMapping("/verify-token")
    public ResponseEntity<Boolean> verifyToken(@RequestBody TokenRole token){
        return new ResponseEntity<>(authService.verifyToken(token),HttpStatus.OK);
    }


    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordReq req){

        System.out.println("newpassword ->> " + req.getNewPassword());
        req.setNewPassword(passwordEncoder.encode(req.getNewPassword()));
        String pass = req.getNewPassword();

        System.out.println("pass ->> " + pass);

        return new ResponseEntity<>(authService.resetPassword(req.getEmail(),pass),HttpStatus.OK);
    }

    @GetMapping("get-user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id){
        return new ResponseEntity<>(authService.getUser(id),HttpStatus.OK);
    }

    @GetMapping("get-all-users")
    public ResponseEntity<List<UsersProxy>> getAllUsers(){
        return new ResponseEntity<>(authService.getAllUsers(), HttpStatus.OK);
    }


//    @PostMapping("/get")

}
