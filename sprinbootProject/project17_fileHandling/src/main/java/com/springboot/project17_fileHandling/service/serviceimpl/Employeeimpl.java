package com.springboot.project17_fileHandling.service.serviceimpl;

import com.github.javafaker.Faker;
import com.springboot.project17_fileHandling.Domain.Employee;
import com.springboot.project17_fileHandling.Proxy.Employeeproxy;
import com.springboot.project17_fileHandling.Repository.Employeerepo;
import com.springboot.project17_fileHandling.helper.Modelmapper;
import com.springboot.project17_fileHandling.service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employeeimpl implements Employeeservice {

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private Modelmapper modelmapper;

    @Autowired
    private Faker faker;

    @Override
    public String saveEmployee(Employeeproxy employeeproxy) {
        employeerepo.save(modelmapper.dtoToEntity(employeeproxy));
        return "saved";
    }

    @Override
    public List<Employeeproxy> getAllEmployee() {
        return modelmapper.listEntityToDto(employeerepo.findAll());
    }

    @Override
    public Employeeproxy getEmployeeByEmail(String email) {
        return modelmapper.entityToDto(employeerepo.findByEmail(email));
    }

    @Override
    public String saveFakeData() {
        for(int i=0;i<100;i++){
            Employee employee =new Employee();
            employee.setName(faker.name().name());
            employee.setEmail(faker.internet().emailAddress());
            employee.setAddress(faker.address().fullAddress());
            employee.setMobileNo(faker.phoneNumber().phoneNumber());

            employeerepo.save(employee);
        }
        return "saved ";
    }
}
