package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Proxy.BloodStockProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<UsersProxy>> getAllUsers(){
        return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.FOUND);
    }


    @GetMapping("getUserByEmail/{email}")
    public ResponseEntity<UsersProxy> getUserById(@PathVariable String email){
        return new ResponseEntity<>(adminService.getUsersByEmail(email),HttpStatus.FOUND);
    }



    @GetMapping("/donor/{id}/approve")
    public ResponseEntity<String> donorApprover(@PathVariable Long id){
        return new ResponseEntity<>(adminService.donorApprover(id),HttpStatus.ACCEPTED);
    }



    @PostMapping("/blood-stock/add")
    public ResponseEntity<String> bloodStockAdd(@RequestBody BloodStockProxy bloodStockProxy){
        return new ResponseEntity<>(adminService.bloodStockAddOrUpdate(bloodStockProxy),HttpStatus.ACCEPTED);
    }

}
