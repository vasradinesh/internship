package com.example.prolect09_oneToonebidirectional.utility;


import com.example.prolect09_oneToonebidirectional.domain.Company;
import com.example.prolect09_oneToonebidirectional.domain.Employee;
import com.example.prolect09_oneToonebidirectional.dto.Companydto;
import com.example.prolect09_oneToonebidirectional.dto.Employeedto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Modelutility {

    @Autowired
    private ModelMapper modelMapper;

    public Employeedto employeeEntityTODto(Employee employee){
        employee.getCompany().setEmployee(null);
        return modelMapper.map(employee, Employeedto.class);
    }

    public Employee employeeDtoToEntity(Employeedto employeedto){
        Employee map = modelMapper.map(employeedto, Employee.class);
        if(map.getCompany()!=null){
            map.getCompany().setEmployee(map);
        }
        return map;
    }

    public List<Employee> listEmployeeDtoToEntity(List<Employeedto> employeedtoList){
        return employeedtoList.stream().map(s->employeeDtoToEntity(s)).toList();
    }

    public List<Employeedto>  listEmployeeEntityToDto(List<Employee> employeeList){
        return employeeList.stream().map(s->employeeEntityTODto(s)).toList();
    }

    public Companydto companyEntityToDto(Company company){
        company.getEmployee().setCompany(null);
        return modelMapper.map(company,Companydto.class);
    }

    public Company companyDtoToEntity(Companydto companydto){
        Company map = modelMapper.map(companydto, Company.class);
        if(map.getEmployee()!=null){
            map.getEmployee().setCompany(map);
        }
        return map;
    }

    public List<Company> listCompanyDtoToEntity(List<Companydto> companydtoList){
        return companydtoList.stream().map(s->companyDtoToEntity(s)).toList();
    }

    public List<Companydto>  listCompanyEntityToDto(List<Company> companyList){
        return companyList.stream().map(s->companyEntityToDto(s)).toList();
    }

}
