package com.springboot.project03.service.serviceImpl;

import com.springboot.project03.models.Employee;
import com.springboot.project03.service.Employeeservice;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements Employeeservice {

    List<Employee> employees = new ArrayList<>();
    @Override
    public String saveEmployee( Employee employee) {
        Optional<Employee> first = employees.stream().filter(s -> Objects.equals(s.getEid(), employee.getEid())).findFirst();
        if (first.isEmpty()){
            employees.add(employee);
            return "Employee of " +   employee.getEid()  + " is successfully added";
        }else {
            return "Employee of " +   employee.getEid()  + " is already there";
        }
    }
    @Override
    public Employee getEmployeeById( Long eid) {
        Optional<Employee> first = employees.stream().filter(s -> Objects.equals(s.getEid(), eid)).findFirst();
        if (first.isEmpty()){
            return new Employee();
        }else {
            return employees.stream().filter(s -> Objects.equals(s.getEid(), eid)).findFirst().get();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }


    @Override
    public String deleteEmployeeById( Long eid) {
        Optional<Employee> first = employees.stream().filter(s -> Objects.equals(s.getEid(), eid)).findFirst();
        if (first.isEmpty()){
            return "there is no employee of given id "+eid;
        }else {
            employees.removeIf(s -> Objects.equals(s.getEid(), eid));
            return "employee is successfully removed";
        }
    }

    @Override
    public String deleteAllEmployee() {
        employees.clear();
        return "All Employee has been deleted";
    }

    @Override
    public String updateEmployeeById(Employee employee,Long eid) {
        Optional<Employee> first = employees.stream().filter(s -> Objects.equals(s.getEid(), eid)).findFirst();
        if (first.isPresent()){
            Employee emp = first.get();
            emp.setName(employee.getName());
            emp.setAddress(employee.getAddress());
            return "Employee of " +   eid  + " is successfully updated ";
        }else {
            return "there is no employee of given id "+eid;
        }
    }
}
