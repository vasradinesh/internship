package com.springboot.project17_fileHandling.Proxy;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileStorageProxy {

    private Long id;
    private String fileName;
    private String filePath;
    private String contentType;
    private String fileSize;
    private String dockId;
    private byte[] fileData;
    private Boolean isActive;
}
