package com.bloodmangement.serviceAdmin.Controller;


import com.bloodmangement.serviceAdmin.Domain.BloodStock;
import com.bloodmangement.serviceAdmin.Proxy.BloodStockProxy;
import com.bloodmangement.serviceAdmin.Proxy.UsersProxy;
import com.bloodmangement.serviceAdmin.Service.AdminService;
import com.bloodmangement.serviceAdmin.Service.ExcelService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
//
    @Autowired
    private ExcelService excelService;

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("get-bloodstock/{bloodgroup}")
    public ResponseEntity<BloodStockProxy> getBloodStock(@PathVariable String bloodgroup){
        return new ResponseEntity<>(adminService.getBloodStock(bloodgroup),HttpStatus.OK);
    }




    @GetMapping("/users")
    public ResponseEntity<List<UsersProxy>> getAllUsers(HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(adminService.getAllUsers(authtoken), HttpStatus.OK);
    }


//    @GetMapping("getUserByEmail/{email}")
//    public ResponseEntity<UsersProxy> getUserById(@PathVariable String email){
//        return new ResponseEntity<>(adminService.getUsersByEmail(email),HttpStatus.OK);
//    }


//
    @GetMapping("/don-approve/{id}")
    public ResponseEntity<String> donorApprover(@PathVariable Long id,HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(adminService.donorApprover(id,authtoken),HttpStatus.ACCEPTED);
    }



    @PostMapping("/blood-stock/add")
    public ResponseEntity<String> bloodStockAdd(@Valid @RequestBody BloodStockProxy bloodStockProxy,HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(adminService.bloodStockAddOrUpdate(bloodStockProxy,authtoken),HttpStatus.ACCEPTED);
    }


    @GetMapping("/bloodrequest/approve/{id}")
    public ResponseEntity<String> bloodRequestApprove(@PathVariable Long id, HttpServletRequest request){
        String authtoken = request.getHeader("Authorization");
        return new ResponseEntity<>(adminService.bloodRequestapprover(id,authtoken),HttpStatus.OK);
    }


    @GetMapping("bloodstockreport/download")
    public ResponseEntity<byte[]> downloadExcelFile(){
        byte[] bytes = excelService.downloadExcelFile();
        String path = "bloodstockreport__"+ UUID.randomUUID().toString()+".xlsx";

        System.out.println(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+path)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }
//
    @GetMapping("blood/requestdata/download")
    public ResponseEntity<byte[]> downloadBloodRequestExcel(){
        byte[] bytes = excelService.getBloodRequestExcel();
        String path = "requestdata__"+ UUID.randomUUID().toString()+".xlsx";

        System.out.println(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+path)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }
//
//
//    @PostMapping("update-user-by-email/{email}")
//    public ResponseEntity<String> updateUserByEmail(@PathVariable String email, @RequestBody UsersProxy usersProxy){
//        return new ResponseEntity<>(adminService.updateUserByEmail(email,usersProxy),HttpStatus.OK);
//    }

}
