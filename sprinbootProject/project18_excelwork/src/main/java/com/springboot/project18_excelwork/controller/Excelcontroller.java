package com.springboot.project18_excelwork.controller;


import com.springboot.project18_excelwork.service.Excelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class Excelcontroller {

    @Autowired
    private Excelservice excelservice;

    @PostMapping(value = "/excelupload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadExceFile(@RequestParam MultipartFile file){
        String s = excelservice.uploadExcelData(file);

        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("excel/download")
    public ResponseEntity<byte[]> downloadExcelFile(){
        byte[] bytes = excelservice.downloadExcelFile();
        String path = "Employee"+ UUID.randomUUID().toString()+".xlsx";

        System.out.println(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+path)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }

    @GetMapping("/blank/excel")
    public ResponseEntity<byte[]> downloadBlankExcelFile(){
        byte[] bytes = excelservice.downloadEmptyExcel();
        String path = "Employee"+ UUID.randomUUID().toString()+".xlsx";

        System.out.println(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+path)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(bytes);
    }


}
