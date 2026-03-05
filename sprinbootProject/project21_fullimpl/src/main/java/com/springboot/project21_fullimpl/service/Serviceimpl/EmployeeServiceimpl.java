package com.springboot.project21_fullimpl.service.Serviceimpl;


import com.springboot.project21_fullimpl.CustomException.NoEmployeeFoundException;
import com.springboot.project21_fullimpl.Entity.Employee;
import com.springboot.project21_fullimpl.Model.AuthReq;
import com.springboot.project21_fullimpl.Model.AuthResp;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;
import com.springboot.project21_fullimpl.Repository.Employeerepo;
import com.springboot.project21_fullimpl.Utils.JWTutility.JwtUtil;
import com.springboot.project21_fullimpl.Utils.Mapperhelper;
import com.springboot.project21_fullimpl.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {


    @Autowired
    private Mapperhelper mapperhelper;

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyEmployeeUserDetails employeeUserDetails;


    @Override
    public String saveEmployee(Employeeproxy employeeproxy) {

        Optional<Employee> byEmail = employeerepo.findByEmail(employeeproxy.getEmail());

        if(byEmail.isPresent()){
            throw new NoEmployeeFoundException("there is employee with same id is already exist enter different email", HttpStatus.NOT_FOUND.toString());
        }else
            employeerepo.save(mapperhelper.proxyToEntity(employeeproxy));
        return "saved";
    }

    @Override
    public Employeeproxy getEmployeeByName(String name) {
        Optional<Employee> byId = employeerepo.findByUserName(name);
        if(byId.isPresent()){
            return mapperhelper.entityToProxy(byId.get());
        }
        throw new NoEmployeeFoundException("there is no such employee of given name : "+name,HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public AuthResp generateToken(AuthReq authReq) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authReq.getUsername(),authReq.getPassword());


        Authentication authenticate = authenticationManager.authenticate(authToken);

        if(authenticate.isAuthenticated()){

            UserDetails userDetails = employeeUserDetails.loadUserByUsername(authReq.getUsername());

            Date expiredOn = new Date();

            expiredOn.setTime(expiredOn.getTime() + 1000 * 60 *60*5);

            String jwttoken = jwtUtil.generateToken(userDetails);

            AuthResp authResp = new AuthResp();
            authResp.setToken(jwttoken);
            authResp.setUsername(authReq.getUsername());
            authResp.setExpiredOn(expiredOn);

            return authResp;

        }

        throw new NoEmployeeFoundException("enter correct username or password",HttpStatus.NOT_FOUND.toString());
    }
}
