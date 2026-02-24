package com.springboot.project17_fileHandling.service.serviceimpl;

import com.springboot.project17_fileHandling.Domain.Filestorage;
import com.springboot.project17_fileHandling.Proxy.FileStorageProxy;
import com.springboot.project17_fileHandling.Repository.Filestoragerepo;
import com.springboot.project17_fileHandling.helper.Modelmapper;
import com.springboot.project17_fileHandling.helper.Storagehelper;
import com.springboot.project17_fileHandling.service.Filestorageservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class Filestorageimpl implements Filestorageservice {

    @Autowired
    private Filestoragerepo filestoragerepo;

    @Value("${document.folder}")
    private String documentPath;

    @Autowired
    private Modelmapper modelmapper;

    @Override
    public String storeFile(MultipartFile file) {

        if (Storagehelper.isvalidateFile(file)){
            try {
                String fileDockId = UUID.randomUUID().toString();
                String originalFilename = file.getOriginalFilename();
                long size = file.getSize();
                Double sizeKb = size/1024.0;
                String contentType = file.getContentType();
//                byte[] bytes = file.getBytes();

                System.out.println("fdaefffffdff");

                //validation of dirctotry
                File file1 = new File(documentPath);
                if (!file1.exists()){
                    System.out.println("ehfgwkfkefbkwef");
                    file1.mkdirs();
                }

                String  fullPath =documentPath+ File.separator+fileDockId+"_"+originalFilename;

                //MyDocumentFolder/efefewf4234cvsdf45234_astronaut-with-pencil-pen-tool-created-clipping-path-included-jpeg-easy-composite (1).jpg


                Files.copy(file.getInputStream(), Path.of(fullPath), StandardCopyOption.REPLACE_EXISTING);



                Filestorage filestorage = Filestorage.builder()
                        .fileName(originalFilename)
                        .contentType(contentType)
                        .fileSize(String.valueOf(sizeKb))
                        .filePath(fullPath)
                        .fileData(null)
                        .dockId(fileDockId)
                        .isActive(true)
                        .build();
                filestoragerepo.save(filestorage);
                return "document has been saved dockId : " + fileDockId;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return "enter correct document";
        }


        return "document is not uploaded";
    }

    @Override
    public FileStorageProxy getFile(String dockid) {
        Optional<Filestorage> filestorage = filestoragerepo.findByDockId(dockid);
        if(filestorage.isPresent()){
            return modelmapper.entityToPoroxy(filestorage.get());
        }else {
            throw new RuntimeException("file not found with docId : "+ dockid);
        }
    }

    @Override
    public String getFileName(String dockid) {
        return "";
    }
}
