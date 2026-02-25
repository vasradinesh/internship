package com.springboot.project16_imageProcessing.service;

import com.springboot.project16_imageProcessing.proxy.Employeeproxy;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface Imageservice {
    String storeFile(MultipartFile file) throws IOException;
}
