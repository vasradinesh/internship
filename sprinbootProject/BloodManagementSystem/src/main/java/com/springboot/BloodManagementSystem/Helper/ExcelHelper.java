package com.springboot.BloodManagementSystem.Helper;

import com.springboot.BloodManagementSystem.Domain.BloodRequest;
import com.springboot.BloodManagementSystem.Domain.BloodStock;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelHelper {

    public byte[]  getExcelFromListOfBloodStock(List<BloodStock> bloodStockList){

        try(ByteArrayOutputStream os = new ByteArrayOutputStream(); Workbook workbook = new XSSFWorkbook()){
            String Headers[] = {"ID","BLOOD GROUP","UNITS_AVAILABLE","LAST_UPDATE"};

            //creat workboook
            ;

            //creat sheet
            Sheet sheet = workbook.createSheet("Blood stock data");

            //first row for headers
            Row headeRow = sheet.createRow(0);

            for (int i=0;i<Headers.length;i++){
                headeRow.createCell(i).setCellValue(Headers[i]);
            }

            //adding list data into other row
            int j=1;
            for(BloodStock blood: bloodStockList){
                Row row = sheet.createRow(j);
                row.createCell(0).setCellValue(blood.getId());
                row.createCell(1).setCellValue(blood.getBloodGroup());
                row.createCell(2).setCellValue(blood.getUnitsAvailable());
                row.createCell(3).setCellValue(blood.getLastUpdated());
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

    public byte[]  getExcelFromListBloodRequest(List<BloodRequest> bloodRequestList){

        try(ByteArrayOutputStream os = new ByteArrayOutputStream(); Workbook workbook = new XSSFWorkbook()){
            String Headers[] = {"ID","BLOOD GROUP","QUANTITY","REQUEST_DATE","STATUS","H_ID","HOSPITAL_NAME","CONTACT_NUMBER","USER_ID","USER_NAME","PHONE_NUMBER"};

            //creat workboook
            ;

            //creat sheet
            Sheet sheet = workbook.createSheet("Blood Request data");

            //first row for headers
            Row headeRow = sheet.createRow(0);

            for (int i=0;i<Headers.length;i++){
                headeRow.createCell(i).setCellValue(Headers[i]);
            }

            //adding list data into other row
            int j=1;
            for(BloodRequest request: bloodRequestList){
                Row row = sheet.createRow(j);
                row.createCell(0).setCellValue(request.getId());
                row.createCell(1).setCellValue(request.getBloodGroup());
                row.createCell(2).setCellValue(request.getQuantity());
                row.createCell(3).setCellValue(request.getRequestDate());
                row.createCell(4).setCellValue(request.getStatus());
                row.createCell(5).setCellValue(request.getHospital().getId());
                row.createCell(6).setCellValue(request.getHospital().getHospitalName());
                row.createCell(7).setCellValue(request.getHospital().getContactNumber());
                row.createCell(8).setCellValue(request.getHospital().getUsers().getId());
                row.createCell(9).setCellValue(request.getHospital().getUsers().getName());
                row.createCell(10).setCellValue(request.getHospital().getUsers().getPhone());
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



}
