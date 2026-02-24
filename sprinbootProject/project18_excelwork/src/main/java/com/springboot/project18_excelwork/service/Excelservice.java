package com.springboot.project18_excelwork.service;

import org.springframework.web.multipart.MultipartFile;

public interface Excelservice {

    String uploadExcelData(MultipartFile excelFile);
    byte[] downloadExcelFile();
    byte[] downloadEmptyExcel();
}
