package com.chadi.aws.controller;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.chadi.aws.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;



    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String health()  {
       return "Service running..";
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        storageService.uploadFile(file);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(@RequestParam(value = "fileName") String fileName, HttpServletResponse response)
            throws IOException {

        InputStream inputStream = storageService.downloadFile(fileName);

        OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader(headerKey, headerValue);

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }

    //https://www.mkyong.com/spring-boot/spring-boot-file-upload-example-ajax-and-rest/
    @PostMapping("/api/uploadone")
    public ResponseEntity<?> uploadMyFile(
            @RequestParam("file") MultipartFile uploadfile) {

        System.out.println("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {
            storageService.uploadFile(uploadfile);

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }
}
