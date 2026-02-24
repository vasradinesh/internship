package com.springboot.project17_fileHandling.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Storagehelper {

    public static Boolean isvalidateFile(MultipartFile file){

        if(file.isEmpty() || file==null){
            return false;
        }else {
            return true;
        }
    }
}
