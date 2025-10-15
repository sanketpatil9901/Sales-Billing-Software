package com.project.billingSoftware.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    private static final String UPLOAD_DIR = System.getProperty("user.dir") 
        + File.separator + "src" + File.separator + "main" + File.separator + "resources"
        + File.separator + "static" + File.separator + "uploads" + File.separator;


    public String uploadFile(MultipartFile file) {
        try {
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = file.getOriginalFilename();
            File fileToSave = new File(UPLOAD_DIR + fileName);

            file.transferTo(fileToSave);
            return "/uploads/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("File uplaod failed: " + e.getMessage());
        }
    }

    public boolean deleteFile(String fileUrl) {
        String fileName = fileUrl.replace("/uploads/", "");
        File file = new File(UPLOAD_DIR + fileName);

        if (file.exists()) {
            return file.delete();
        } else {
            System.out.println("File not found: " + file.getAbsolutePath());
            return false;
        }
    }
}
