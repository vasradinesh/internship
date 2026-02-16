package com.example.prolect09_oneToonebidirectional.service.serviceimpl;

import com.example.prolect09_oneToonebidirectional.domain.Employee;
import com.example.prolect09_oneToonebidirectional.dto.Employeedto;
import com.example.prolect09_oneToonebidirectional.repository.Employeerepo;
import com.example.prolect09_oneToonebidirectional.service.Employeeservice;
import com.example.prolect09_oneToonebidirectional.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employeeimpl implements Employeeservice {

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private Modelutility modelutility;


    @Override
    public Employeedto getEmployeeById(Long id) {
        Employeedto employeedto = modelutility.employeeEntityTODto(employeerepo.findById(id).get());
        if (employeedto==null){
            return new Employeedto();
        }else {
            return employeedto;
        }
    }

    @Override
    public String saveAllEmployee(Employeedto employeedto) {
        employeerepo.save(modelutility.employeeDtoToEntity(employeedto));
        return "saved";
    }

    @Override
    public List<Employeedto> getAllEmployee() {
        return modelutility.listEmployeeEntityToDto(employeerepo.findAll());
    }

    @Override
    public String deleteEmployeeById(Long id) {
        Optional<Employee> byId = employeerepo.findById(id);
        if (byId.isPresent()){
            employeerepo.deleteById(id);
            return "deleted";
        }
        return "there is no id like"+ id;
    }

    @Override
    public String updateEmployeeById(Long id, Employeedto employeedto) {
        Optional<Employee> byId = employeerepo.findById(id);
        if(byId.isPresent()){
//            employeedto.setId(byId.get().getId());
            employeerepo.save(modelutility.employeeDtoToEntity(employeedto));
            return "updated";
        }
        return "there is no such id exist";
    }
}
