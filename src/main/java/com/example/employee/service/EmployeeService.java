package com.example.employee.service;

import com.example.employee.dtoEdit.EmployeeDTOEdit;
import com.example.employee.dtoIn.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    MinioClient minioClient;

    public List<EmployeeModel> searchEmployee(String query) {
        return employeeRepository.searchEmployee(query);
    }

    public EmployeeModel createEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setCode(generateCode());
        employeeModel.setTitleName(employeeDTO.getTitleName());
        employeeModel.setFirstName(employeeDTO.getFirstName());
        employeeModel.setLastName(employeeDTO.getLastName());
        employeeModel.setNickName(employeeDTO.getNickName());
        employeeModel.setBirthday(employeeDTO.getBirthday());
        employeeModel.setGender(employeeDTO.getGender());
        employeeModel.setSlackName(employeeDTO.getSlackName());
        employeeModel.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeModel.setEmail(employeeDTO.getEmail());
        employeeModel.setStartDate(employeeDTO.getStartDate());
        employeeModel.setStatus(true);
        employeeModel.setDepartment(employeeDTO.getDepartment());
        employeeModel.setPosition(employeeDTO.getPosition());
        return employeeRepository.save(employeeModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('employee_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "E-" + (seq + 1);
        return code;
    }

    public EmployeeModel editEmployee(EmployeeDTOEdit employeeDTOEdit, String query){
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        employeeModel.setTitleName(employeeDTOEdit.getTitleName());
        employeeModel.setFirstName(employeeDTOEdit.getFirstName());
        employeeModel.setLastName(employeeDTOEdit.getLastName());
        employeeModel.setNickName(employeeDTOEdit.getNickName());
        employeeModel.setBirthday(employeeDTOEdit.getBirthday());
        employeeModel.setGender(employeeDTOEdit.getGender());
        employeeModel.setSlackName(employeeDTOEdit.getSlackName());
        employeeModel.setPhoneNumber(employeeDTOEdit.getPhoneNumber());
        employeeModel.setEmail(employeeDTOEdit.getEmail());
        employeeModel.setStartDate(employeeDTOEdit.getStartDate());
        employeeModel.setEndDate(employeeDTOEdit.getEndDate());
        employeeModel.setStatus(checkEndDate(employeeModel.getEndDate()));
        employeeModel.setDepartment(employeeDTOEdit.getDepartment());
        employeeModel.setPosition(employeeDTOEdit.getPosition());
        return employeeRepository.save(employeeModel);
    }
    public boolean checkEndDate(LocalDate endDate){
        if(endDate == null){
            return true;
        }
        else {
            return false;
        }
    }

    public List<EmployeeModel> getEmployee(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(String query){
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        employeeRepository.deleteById(employeeModel.getId());
        deleteFile(employeeModel);
    }

    public ResponseEntity<String> uploadFile(MultipartFile file,String query) {
        try {
            EmployeeModel employeeModel = employeeRepository.findByCode(query);
            String bucketName = "image";
            String objectName =employeeModel.getCode() + file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream stream = file.getInputStream();
            saveFile(bucketName, objectName, stream, contentType);

            if(employeeModel.getImage() != null){
                deleteFile(employeeModel);
            }

            employeeModel.setImage(objectName);
            employeeRepository.save(employeeModel);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    public ResponseEntity<byte[]> getImageEmployee(String query) {
        try{
            byte[] data = getFile(query);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //function
    public void saveFile(String bucketName, String objectName, InputStream stream, String contentType) {
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

    public byte[] getFile(String query) {
        try {
            EmployeeModel employeeModel = employeeRepository.findByCode(query);
            GetObjectArgs args = GetObjectArgs.builder()
                    .bucket("image")
                    .object(employeeModel.getImage())
                    .build();
            return minioClient.getObject(args).readAllBytes();
        } catch (Exception e) {
            return "Failed in function getFile".getBytes();
        }
    }

    public void deleteFile(EmployeeModel employeeModel){
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket("image")
                            .object(employeeModel.getImage())
                            .build()
            );
        }
        catch (Exception e){
            System.out.println("delete image failed");
        }
    }

}
