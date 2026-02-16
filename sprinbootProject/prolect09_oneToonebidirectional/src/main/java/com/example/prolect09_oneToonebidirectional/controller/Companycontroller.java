package com.example.prolect09_oneToonebidirectional.controller;


import com.example.prolect09_oneToonebidirectional.domain.Company;
import com.example.prolect09_oneToonebidirectional.dto.Companydto;
import com.example.prolect09_oneToonebidirectional.service.Companyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Companycontroller {

    @Autowired
    private Companyservice companyservice;

    @GetMapping("get-company-by-id/{id}")
    public Companydto getCompanyById(@PathVariable Long id) {
        return companyservice.getCompanyById(id);
    }

    @PostMapping("save-company")
    public String saveCompany(@RequestBody Companydto companydto) {
        return companyservice.saveCompany(companydto);
    }

    @GetMapping("get-all-employee")
    public List<Companydto> getAllCompany() {
        return companyservice.getAllCompany();
    }

    @DeleteMapping("delete-company-by-id/{id}")
    public String deleteCompanyById(@PathVariable Long id) {
        return companyservice.deleteCompanyById(id);
    }

    @PostMapping("update-company-by-id/{id}")
    public String updatedCompanyBYId(@PathVariable Long id,@RequestBody Companydto companydto) {
        return companyservice.updatedCompanyBYId(id,companydto);
    }

    @DeleteMapping("delete-all-company")
    public String deleteAllCompany() {
        return companyservice.deleteAllCompany();
    }

}
