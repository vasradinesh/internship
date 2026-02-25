package com.springboot.project16_imageProcessing.proxy;

import lombok.Data;

@Data
public class Imageproxy {
    private Long id;
    private String fileName;
    private String filePath;
    private String contentType;
    private String fileSize;
    private String dockId;
    private byte[] fileData;
}
