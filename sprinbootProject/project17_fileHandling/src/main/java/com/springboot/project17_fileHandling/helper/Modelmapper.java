package com.springboot.project17_fileHandling.helper;

import com.springboot.project17_fileHandling.Domain.Employee;
import com.springboot.project17_fileHandling.Domain.Filestorage;
import com.springboot.project17_fileHandling.Proxy.Employeeproxy;
import com.springboot.project17_fileHandling.Proxy.FileStorageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
public class Modelmapper {
    @Autowired
    private ObjectMapper objectMapper;

    public Employee dtoToEntity(Employeeproxy employeeproxy){
        return objectMapper.convertValue(employeeproxy, Employee.class);
    }

    public Employeeproxy entityToDto(Employee student){
        return objectMapper.convertValue(student, Employeeproxy.class);
    }

    public List<Employee> listDtoToEntity(List<Employeeproxy> studentdtoList){
        return studentdtoList.stream().map(s->dtoToEntity(s)).toList();
    }

    public List<Employeeproxy> listEntityToDto(List<Employee> studentList){
        return studentList.stream().map(s->entityToDto(s)).toList();
    }

    public FileStorageProxy entityToPoroxy(Filestorage filestorage){
        return objectMapper.convertValue(filestorage, FileStorageProxy.class);
    }

}
