package com.springboot.project04_orm_sql.conteoller;


import com.springboot.project04_orm_sql.models.Employee;
import com.springboot.project04_orm_sql.service.seviceimplementation.employeeIMpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class employeecontroller {

    @Autowired
    private employeeIMpl employeeIMpl;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeIMpl.saveEmployee(employee);
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeIMpl.getAllEmployee();
    }

    @GetMapping("/getEmployeeById/{eid}")
    public Employee getEmployeeById(@PathVariable Long eid) {
        return employeeIMpl.getEmployeeById(eid);
    }

    @DeleteMapping("deleteEmployeeById/{eid}")
    public String deleteEmployeeById(@PathVariable Long eid) {
        return employeeIMpl.deleteEmployeeById(eid);
    }

    @DeleteMapping("deleteAllEmployee")
    public String deleteAllEmployee() {
        return employeeIMpl.deleteAllEmployee();
    }

    @PutMapping("updateEmployeeById/{eid}")
    public String updateEmployeeById(@PathVariable Long eid, @RequestBody Employee employee) {
        return employeeIMpl.updateEmployeeById(eid,employee);
    }

}
