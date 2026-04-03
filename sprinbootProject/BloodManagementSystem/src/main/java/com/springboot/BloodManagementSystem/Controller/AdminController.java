package com.springboot.BloodManagementSystem.Controller;


import com.springboot.BloodManagementSystem.Proxy.BloodStockProxy;
import com.springboot.BloodManagementSystem.Proxy.DonationProxy;
import com.springboot.BloodManagementSystem.Proxy.UsersProxy;
import com.springboot.BloodManagementSystem.Service.AdminService;
import com.springboot.BloodManagementSystem.Service.ExcelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/users")
    public ResponseEntity<List<UsersProxy>> getAllUsers(){
        return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("getUserByEmail/{email}")
    public ResponseEntity<UsersProxy> getUserById(@PathVariable String email){
        return new ResponseEntity<>(adminService.getUsersByEmail(email),HttpStatus.OK);
    }



    @GetMapping("/donor/{id}/approve")
    public ResponseEntity<String> donorApprover(@PathVariable Long id){
        return new ResponseEntity<>(adminService.donorApprover(id),HttpStatus.ACCEPTED);
    }




    @PostMapping("/blood-stock/add")
    public ResponseEntity<String> bloodStockAdd(@Valid @RequestBody BloodStockProxy bloodStockProxy){
        return new ResponseEntity<>(adminService.bloodStockAddOrUpdate(bloodStockProxy),HttpStatus.ACCEPTED);
    }


    @GetMapping("/bloodrequest/approve/{id}")
    public ResponseEntity<String> bloodRequestApprove(@PathVariable Long id){
        return new ResponseEntity<>(adminService.bloodRequestapprover(id),HttpStatus.OK);
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


    @PostMapping("update-user-by-email/{email}")
    public ResponseEntity<String> updateUserByEmail(@PathVariable String email, @RequestBody UsersProxy usersProxy){
        return new ResponseEntity<>(adminService.updateUserByEmail(email,usersProxy),HttpStatus.OK);
    }

    @DeleteMapping("delete-user-by-email/{email}")
    public ResponseEntity<String > deletebyemail(@PathVariable String email){
        System.out.println(email);
        return new ResponseEntity<>(adminService.deleteuserbyemail(email),HttpStatus.OK);
    }

    @GetMapping("get-all-donation")
    public ResponseEntity<List<DonationProxy>> getAlldonation(){
        return new ResponseEntity<>(adminService.getAllDonation(),HttpStatus.OK);
    }

}
