package com.springboot.BloodManagementSystem.Service;

public interface ExcelService {

    byte[] downloadExcelFile();

    byte[]  getBloodRequestExcel();

}
