package com.springboot.project21_fullimpl.Controller;


import com.springboot.project21_fullimpl.CustomException.NoEmployeeFoundException;
import com.springboot.project21_fullimpl.Model.AuthReq;
import com.springboot.project21_fullimpl.Model.AuthResp;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;
import com.springboot.project21_fullimpl.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class Employeecontroller {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @PostMapping("/save-employee")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employeeproxy employeeproxy){

        if(employeeproxy==null){
            throw new NoEmployeeFoundException("enter details",HttpStatus.NOT_ACCEPTABLE.toString());
        }
        employeeproxy.setPassword(passwordEncoder.encode(employeeproxy.getPassword()));
         String s = employeeService.saveEmployee(employeeproxy);

         return new ResponseEntity<>(s, HttpStatus.CREATED);
    }


    @GetMapping("get-employee-by-name/{name}")
    public ResponseEntity<Employeeproxy> getEmployeeById(@PathVariable String name){

        Employeeproxy employeeById = employeeService.getEmployeeByName(name);

        return new ResponseEntity<>(employeeById,HttpStatus.FOUND);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResp> getLogin(@RequestBody AuthReq authReq){
        return new ResponseEntity<>(employeeService.generateToken(authReq),HttpStatus.FOUND);
    }

}
