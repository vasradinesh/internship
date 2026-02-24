package com.springboot.project17_fileHandling.service;

import com.springboot.project17_fileHandling.Domain.Filestorage;
import com.springboot.project17_fileHandling.Proxy.FileStorageProxy;
import org.springframework.web.multipart.MultipartFile;

public interface Filestorageservice {

    String storeFile(MultipartFile file);
    FileStorageProxy getFile(String dockid);
    String getFileName(String dockid);
}
