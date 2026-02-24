package com.springboot.project17_fileHandling.Controller;

import com.springboot.project17_fileHandling.Domain.Filestorage;
import com.springboot.project17_fileHandling.Proxy.FileStorageProxy;
import com.springboot.project17_fileHandling.service.Filestorageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileStorageController {


    @Autowired
    private Filestorageservice filestorageservice;

    @PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file){
        String s = filestorageservice.storeFile(file);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/download/{dockid}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String dockid) throws IOException {
        FileStorageProxy file = filestorageservice.getFile(dockid);

        String filePath = file.getFilePath();
        System.err.println(filePath);
        Path path = Paths.get(filePath);

        byte[] bytes = Files.readAllBytes(path);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+file.getFileName()).contentType(MediaType.parseMediaType(file.getContentType()) ).body(bytes);
    }


}
