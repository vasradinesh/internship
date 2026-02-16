package com.example.prolect09_oneToonebidirectional.service;

import com.example.prolect09_oneToonebidirectional.dto.Companydto;

import java.util.List;

public interface Companyservice {
    public Companydto getCompanyById(Long id);
    public String saveCompany(Companydto companydto);
    public List<Companydto> getAllCompany();
    public String deleteCompanyById(Long id);
    public String updatedCompanyBYId(Long id,Companydto companydto);
    public String deleteAllCompany();

}
