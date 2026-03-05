package com.springboot.project21_fullimpl.service.Serviceimpl;


import com.springboot.project21_fullimpl.CustomException.NoEmployeeFoundException;
import com.springboot.project21_fullimpl.Entity.Employee;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;
import com.springboot.project21_fullimpl.Repository.Employeerepo;
import com.springboot.project21_fullimpl.Utils.Mapperhelper;
import com.springboot.project21_fullimpl.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private Mapperhelper mapperhelper;


    @Override
    @Transactional
    public String deleteEmployeeByUserName(String name) {
        Optional<Employee> byId = employeerepo.findByUserName(name);
        if(byId.isPresent()){
            employeerepo.deleteByUserName(name);
            return "employee of given name : "+ name+ " has been deleted ";
        }
        throw new NoEmployeeFoundException("there is no such employee of given name : "+name, HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public String updateEmployeeByUserName(String name, Employeeproxy employeeproxy) {
        Optional<Employee> byId = employeerepo.findByUserName(name);
        if(byId.isPresent()){
            employeerepo.save(mapperhelper.proxyToEntity(employeeproxy));
            return "updated";
        }
        throw new NoEmployeeFoundException("there is no such employee of given name : "+name, HttpStatus.NOT_FOUND.toString());
    }

    @Override
    public List<Employeeproxy> getAllEmployee() {
        List<Employee> all = employeerepo.findAll();
        List<Employeeproxy> list = all.stream().map(m -> mapperhelper.entityToProxy(m)).toList();
        return list;
    }
}
