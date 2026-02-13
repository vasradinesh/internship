package com.springboot.project04_orm_sql.service.seviceimplementation;

import com.springboot.project04_orm_sql.models.Employee;
import com.springboot.project04_orm_sql.repository.employeerepo;
import com.springboot.project04_orm_sql.service.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeIMpl implements employeeservice {

    @Autowired
    private employeerepo employeerepo;

    @Override
    public String saveEmployee(Employee employee) {
        Optional<Employee> e=  employeerepo.findById(employee.getEid());
        if(e.isPresent()){
            return "given id is already exist";
        }else {
            return employeerepo.save(employee).toString();
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeerepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long eid) {
        Optional<Employee> e=  employeerepo.findById(eid);
        if(e.isPresent()){
            return e.get();
        }else {
            return new Employee();
        }
    }

    @Override
    public String deleteEmployeeById(Long eid) {
        Optional<Employee> e=  employeerepo.findById(eid);
        if(e.isPresent()){
            employeerepo.deleteById(eid);
            return "successfully removed";
        }else {
            return "there is no given id available";
        }
    }

    @Override
    public String deleteAllEmployee() {
         employeerepo.deleteAll();
        return "delete alle employee";
    }

    @Override
    public String updateEmployeeById(Long eid, Employee employee) {
        Optional<Employee> employee1 = employeerepo.findById(eid);
        if (employee1.isPresent()){
            employeerepo.save(employee);
            return "updated";
        }else {
            return "there is no employee of this id";
        }
    }
}
