package com.springboot.practice02.service.implementation;

import com.springboot.practice02.models.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class EmployeeIplemantation {
    List<Employee> employees = new ArrayList<>();

    public String saveEmployee(Employee employee){
        Optional<Employee> first = employees.stream().filter(s -> Objects.equals(employee.getEmpId(), s.getEmpId())).findFirst();
        if (first.isEmpty()){
            employees.add(employee);
            return "Employee is successfully added";
        }
        return "Employee id "+employee.getEmpId()+" details is already available";
    }

    public List<Employee> getAllEmployees(){
        if (employees.isEmpty()){
            employees.add(new Employee(0,null,null,null,null));
            return employees;
        }
        return employees;
    }

    public Employee getEmpById(Long empId){

        Employee employee = employees.stream().filter(s -> s.getEmpId() == empId).findFirst().get();
        if (employee==null){
            return new Employee(0,null,null,null,null);
        }
        return employee;
    }

    public String DeleteAllEmp(){
        employees.clear();
        return "all employee are removed";
    }

    public String deleteEmpById(Long empId){
        boolean b = employees.removeIf(s -> empId.equals(s.getEmpId()));
        if(b){
            return "employee of "+empId+" is successfully removed";
        }else {
            return "there is no " + empId+" related data";
        }
    }

    public String updateEmpByid(Long empId,Employee employee){
        Optional<Employee> first = employees.stream().filter(s -> s.getEmpId() == empId).findFirst();
        if (first.isPresent()){
            Employee employee1 = first.get();
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmpAddress(employee.getEmpAddress());
            employee1.setRole(employee.getRole());
            employee1.setDate(employee.getDate());
            return "details is successfully updated";
        }else {
            return "details is not available that you want to update";
        }
    }
}
