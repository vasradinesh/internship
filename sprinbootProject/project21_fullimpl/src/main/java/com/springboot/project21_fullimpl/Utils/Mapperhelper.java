package com.springboot.project21_fullimpl.Utils;


import com.springboot.project21_fullimpl.Entity.Employee;
import com.springboot.project21_fullimpl.Proxy.Employeeproxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class Mapperhelper {


    @Autowired
    private ObjectMapper objectMapper;


    public Employee proxyToEntity(Employeeproxy employeeproxy){
        return objectMapper.convertValue(employeeproxy, Employee.class);
    }

    public Employeeproxy entityToProxy(Employee employee){
        return objectMapper.convertValue(employee, Employeeproxy.class);
    }

}
