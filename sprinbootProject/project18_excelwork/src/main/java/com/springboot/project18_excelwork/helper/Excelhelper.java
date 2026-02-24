package com.springboot.project18_excelwork.helper;

import com.springboot.project18_excelwork.Domain.Employee;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Excelhelper {


    public static Boolean isValidExcel(MultipartFile excelFile) {
        if (excelFile == null || excelFile.isEmpty())
            return false;

        if (!excelFile.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return false;

        return true;
    }


    public List<Employee> getDataFromExcelSheet(MultipartFile excelFile){

        List<Employee> employeeList = new ArrayList<>();

        // get input stream form eFile
        // Get object of XSSFWorkbook by using input stream object
        try ( XSSFWorkbook workbook=new XSSFWorkbook(excelFile.getInputStream())){

            //get sheet from work book
            XSSFSheet sheet = workbook.getSheetAt(0);

            //get tatal row
            int lastRowNo = sheet.getLastRowNum();

            //skipheader row starting with 1

            for(int i=1;i<=lastRowNo;i++){

                XSSFRow row = sheet.getRow(i);

                Employee employee = Employee.builder()
                        .name(row.getCell(1).getStringCellValue())
                        .email(row.getCell(2).getStringCellValue())
                        .mobileNo(row.getCell(3).getRawValue())
                        .address(row.getCell(4).getStringCellValue())
                        .build();
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return employeeList;

    }

    public static byte[] getExcelSheetFromListOfEmployee(List<Employee> employeeList){

        try(ByteArrayOutputStream os = new ByteArrayOutputStream();Workbook workbook = new XSSFWorkbook()){
            String Headers[] = {"ID","NAME","EMAIL_ID","MOBILE_NO","ADDRESS"};

            //creat workboook
            ;

            //creat sheet
            Sheet sheet = workbook.createSheet("Employee_data");

            //first row for headers
            Row headeRow = sheet.createRow(0);

            for (int i=0;i<Headers.length;i++){
                headeRow.createCell(i).setCellValue(Headers[i]);
            }

            //adding list data into other row
            int j=1;
            for(Employee emp : employeeList){
                Row row = sheet.createRow(j);
                row.createCell(0).setCellValue(emp.getId());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getEmail());
                row.createCell(3).setCellValue(emp.getMobileNo());
                row.createCell(4).setCellValue(emp.getAddress());

                j++;
            }

            for (int k=0;k< Headers.length;k++){
                sheet.autoSizeColumn(k);
            }

            workbook.write(os);
            return os.toByteArray();

        }catch (IOException e){
            e.printStackTrace();
        }


       return null;


    }

    public static byte[] downloadEmptyExcel(){
        try(ByteArrayOutputStream os = new ByteArrayOutputStream();Workbook workbook = new XSSFWorkbook()){
            String Headers[] = {"ID","NAME","EMAIL_ID","MOBILE_NO","ADDRESS"};

            //creat workboook
            ;

            //creat sheet
            Sheet sheet = workbook.createSheet("Employee_data");

            //first row for headers
            Row headeRow = sheet.createRow(0);

            for (int i=0;i<Headers.length;i++){
                headeRow.createCell(i).setCellValue(Headers[i]);
            }


            for (int k=0;k< Headers.length;k++){
                sheet.autoSizeColumn(k);
            }

            workbook.write(os);
            return os.toByteArray();

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }


}

