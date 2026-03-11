package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Model.AuthReq;
import com.springboot.BloodManagementSystem.Model.AuthResp;
import com.springboot.BloodManagementSystem.Model.OtpVerificationReq;
import com.springboot.BloodManagementSystem.Model.ResetPasswordReq;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/resetPassword")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordReq req){

        System.out.println("newpassword ->> " + req.getNewPassword());
        req.setNewPassword(passwordEncoder.encode(req.getNewPassword()));
        String pass = req.getNewPassword();

        System.out.println("pass ->> " + pass);

        return new ResponseEntity<>(authService.resetPassword(req.getEmail(),pass),HttpStatus.OK);
    }

}
