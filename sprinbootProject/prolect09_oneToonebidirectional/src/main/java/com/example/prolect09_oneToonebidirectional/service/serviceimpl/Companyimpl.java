package com.example.prolect09_oneToonebidirectional.service.serviceimpl;

import com.example.prolect09_oneToonebidirectional.domain.Company;
import com.example.prolect09_oneToonebidirectional.dto.Companydto;
import com.example.prolect09_oneToonebidirectional.repository.Companyrepo;
import com.example.prolect09_oneToonebidirectional.service.Companyservice;
import com.example.prolect09_oneToonebidirectional.utility.Modelutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Service
public class Companyimpl implements Companyservice {

    @Autowired
    private Modelutility modelutility;

    @Autowired
    private Companyrepo companyrepo;


    @Override
    public Companydto getCompanyById(Long id) {
        Optional<Company> byId = companyrepo.findById(id);
        if (byId.isPresent()){
            return modelutility.companyEntityToDto(byId.get());
        }else {
            return new Companydto();
        }
    }

    @Override
    public String saveCompany(Companydto companydto) {
        companydto.getEmployee().setCompany(companydto);
        companyrepo.save(modelutility.companyDtoToEntity(companydto));
        return "saved";
    }

    @Override
    public List<Companydto> getAllCompany() {
        return modelutility.listCompanyEntityToDto(companyrepo.findAll());
    }

    @Override
    public String deleteCompanyById(Long id) {
        Optional<Company> byId = companyrepo.findById(id);
        if(byId.isPresent()){
            companyrepo.deleteById(id);
            return "deleted";
        }
        return "there is no such id exist";
    }

    @Override
    public String updatedCompanyBYId(Long id, Companydto companydto) {
        Optional<Company> byId = companyrepo.findById(id);
        if(byId.isPresent()){
            companyrepo.save(modelutility.companyDtoToEntity(companydto));
            return "updated";
        }
        return "there is no such id exist";
    }

    @Override
    public String deleteAllCompany() {
        companyrepo.deleteAll();
        return "all deleted";
    }
}
