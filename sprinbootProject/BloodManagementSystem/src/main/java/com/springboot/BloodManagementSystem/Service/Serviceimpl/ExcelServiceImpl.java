package com.springboot.BloodManagementSystem.Service.Serviceimpl;

import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Domain.BloodStock;
import com.springboot.BloodManagementSystem.Helper.ExcelHelper;
import com.springboot.BloodManagementSystem.Repository.BloodRequestrepo;
import com.springboot.BloodManagementSystem.Repository.BloodStockrepo;
import com.springboot.BloodManagementSystem.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private BloodStockrepo bloodStockrepo;

    @Autowired
    private ExcelHelper excelHelper;

    @Autowired
    private BloodRequestrepo bloodRequestrepo;

    @Override
    public byte[] downloadExcelFile() {
        List<BloodStock> all = bloodStockrepo.findAll();
        return excelHelper.getExcelFromListOfBloodStock(all);
    }

    @Override
    public byte[] getBloodRequestExcel() {
        List<BloodRequest> all = bloodRequestrepo.findAll();
        return excelHelper.getExcelFromListBloodRequest(all);
    }


}
