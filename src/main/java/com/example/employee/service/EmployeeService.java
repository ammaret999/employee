package com.example.employee.service;

import com.example.employee.dtoEdit.EmployeeDTOEdit;
import com.example.employee.dtoIn.EmployeeDTO;
import com.example.employee.dtoOut.Base64DTOOut;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.*;

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
import java.util.Base64;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TitleNameRepository titleNameRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PositionRepository positionRepository;
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
        employeeModel.setTitleName(titleNameRepository.findById(employeeDTO.getTitleName()).orElse(null));
        employeeModel.setFirstName(employeeDTO.getFirstName());
        employeeModel.setLastName(employeeDTO.getLastName());
        employeeModel.setNickName(employeeDTO.getNickName());
        employeeModel.setBirthday(employeeDTO.getBirthday());
        employeeModel.setGender(genderRepository.findById(employeeDTO.getGender()).orElse(null));
        employeeModel.setSlackName(employeeDTO.getSlackName());
        employeeModel.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeModel.setEmail(employeeDTO.getEmail());
        employeeModel.setStartDate(employeeDTO.getStartDate());
        employeeModel.setStatus(true);
        employeeModel.setDepartment(departmentRepository.findById(employeeDTO.getDepartment()).orElse(null));
        employeeModel.setPosition(positionRepository.findById(employeeDTO.getPosition()).orElse(null));
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
        employeeModel.setTitleName(titleNameRepository.findById(employeeDTOEdit.getTitleName()).orElse(null));
        employeeModel.setFirstName(employeeDTOEdit.getFirstName());
        employeeModel.setLastName(employeeDTOEdit.getLastName());
        employeeModel.setNickName(employeeDTOEdit.getNickName());
        employeeModel.setBirthday(employeeDTOEdit.getBirthday());
        employeeModel.setGender(genderRepository.findById(employeeDTOEdit.getGender()).orElse(null));
        employeeModel.setSlackName(employeeDTOEdit.getSlackName());
        employeeModel.setPhoneNumber(employeeDTOEdit.getPhoneNumber());
        employeeModel.setEmail(employeeDTOEdit.getEmail());
        employeeModel.setStartDate(employeeDTOEdit.getStartDate());
        employeeModel.setEndDate(employeeDTOEdit.getEndDate());
        employeeModel.setStatus(checkEndDate(employeeModel.getEndDate()));
        employeeModel.setDepartment(departmentRepository.findById(employeeDTOEdit.getDepartment()).orElse(null));
        employeeModel.setPosition(positionRepository.findById(employeeDTOEdit.getPosition()).orElse(null));
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

    public EmployeeModel getEmployeeByCode(String code) {
        EmployeeModel employeeModel = employeeRepository.findByCode(code);
        return employeeModel;
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
            String objectName = employeeModel.getCode() + file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream stream = file.getInputStream();
            saveFile(bucketName, objectName, stream, contentType);

            if(employeeModel.getImage() != null){
                deleteFile(employeeModel);
            }

            employeeModel.setImage(objectName);
            employeeRepository.save(employeeModel);
            return ResponseEntity.ok("uploaded successfully");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    public Base64DTOOut getImageEmployee(String query) {
            byte[] data = getFile(query);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            String base64String = Base64.getEncoder().encodeToString(data);
            Base64DTOOut base64DTOOut = new Base64DTOOut();
            base64DTOOut.setBase64(base64String);
            new ResponseEntity<>(data, headers, HttpStatus.OK);
            return base64DTOOut;
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
            System.out.println(e);
        }
    }



}
