package com.springboot.project18_excelwork.service.serviceimpl;

import com.springboot.project18_excelwork.Domain.Employee;
import com.springboot.project18_excelwork.helper.Excelhelper;
import com.springboot.project18_excelwork.repository.Employeerepo;
import com.springboot.project18_excelwork.service.Excelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class Excelimpl implements Excelservice {


    @Autowired
    private Excelhelper excelhelper;

    @Autowired
    private Employeerepo employeerepo;

    @Override
    public String uploadExcelData(MultipartFile excelFile) {
        if(Excelhelper.isValidExcel(excelFile)){
            List<Employee> dataFromExcelSheet = excelhelper.getDataFromExcelSheet(excelFile);
            employeerepo.saveAll(dataFromExcelSheet);
            return "excel sheet is uploaded";
        }
        return "upload valid file";
    }

    @Override
    public byte[] downloadExcelFile() {
        List<Employee> all = employeerepo.findAll();
        return Excelhelper.getExcelSheetFromListOfEmployee(all);
    }

    @Override
    public byte[] downloadEmptyExcel() {
        return Excelhelper.downloadEmptyExcel();
    }
}
