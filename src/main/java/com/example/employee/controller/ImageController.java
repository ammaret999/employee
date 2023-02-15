package com.example.employee.controller;

import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
public class ImageController {
    @Autowired
    private MinioClient minioClient;
    @Autowired
    private EmployeeRepository employeeRepository;


    public void uploadFile(String bucketName, String objectName, InputStream stream, String contentType) {
        try {
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(stream, stream.available(), -1)
                    .contentType(contentType)
                    .build();
            minioClient.putObject(args);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable(value = "id") Long id) {
        try {
            String bucketName = "image";
            String objectName = file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream stream = file.getInputStream();
            uploadFile(bucketName, objectName, stream, contentType);
            EmployeeModel employeeModel = employeeRepository.findById(Long.valueOf(id)).get();
            employeeModel.setImage(objectName);
            employeeRepository.save(employeeModel);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    public byte[] getFile(Long id) {
        EmployeeModel employeeModel = employeeRepository.findById(Long.valueOf(id)).get();
        try {
            GetObjectArgs args = GetObjectArgs.builder()
                    .bucket("image")
                    .object(employeeModel.getImage())
                    .build();
            return minioClient.getObject(args).readAllBytes();
        } catch (Exception e) {
            return "Failed in function getFile".getBytes();
        }
    }

    @GetMapping("file/{id}")
    public ResponseEntity<byte[]> inputData(@PathVariable(value = "id") Long id){
        try{
            byte[] data = getFile(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
