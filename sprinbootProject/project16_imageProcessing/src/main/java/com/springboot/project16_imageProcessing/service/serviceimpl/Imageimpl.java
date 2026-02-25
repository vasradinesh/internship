package com.springboot.project16_imageProcessing.service.serviceimpl;

import com.springboot.project16_imageProcessing.Repository.Imagerepo;
import com.springboot.project16_imageProcessing.proxy.Employeeproxy;
import com.springboot.project16_imageProcessing.service.Imageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class Imageimpl implements Imageservice {

    @Autowired
    private Imagerepo imagerepo;

    @Override
    public String storeFile(MultipartFile file) throws IOException {String fileDockId = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        long size = file.getSize();
        Double sizeKb = size/1024.0;
        String contentType = file.getContentType();
        byte[] bytes = file.getBytes();
        return "ok";
    }
}
