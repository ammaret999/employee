package com.example.employee.service;

import com.example.employee.dtoEdit.EmployeeDTOEdit;
import com.example.employee.dtoIn.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

//    public EmployeeService(EmployeeRepository employeeRepository){
//        this.employeeRepository = employeeRepository;
//    }

    public List<EmployeeModel> searchEmployee(String query) {
        return employeeRepository.searchEmployee(query);
    }

    public EmployeeModel createEmployee(EmployeeDTO employeeDTO){
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setCode(generate());
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

    public String generate() {
        return "E-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public EmployeeModel editEmployee(EmployeeDTOEdit employeeDTOEdit, Long id){
        EmployeeModel employeeModel = employeeRepository.findById(Long.valueOf(id)).get();
        employeeModel.setCode(employeeDTOEdit.getCode());
        employeeModel.setTitleName(employeeDTOEdit.getTitleName());
        employeeModel.setFirstName(employeeDTOEdit.getFirstName());
        employeeModel.setLastName(employeeDTOEdit.getLastName());
        employeeModel.setNickName(employeeDTOEdit.getNickName());
        employeeModel.setBirthday(employeeDTOEdit.getBirthday());
        employeeModel.setImage("file");
        employeeModel.setGender(employeeDTOEdit.getGender());
        employeeModel.setSlackName(employeeDTOEdit.getSlackName());
        employeeModel.setPhoneNumber(employeeDTOEdit.getPhoneNumber());
        employeeModel.setEmail(employeeDTOEdit.getEmail());
        employeeModel.setStartDate(employeeDTOEdit.getStartDate());
        employeeModel.setEndDate(employeeDTOEdit.getEndDate());
        employeeModel.setStatus(checkEndDate(employeeModel.getEndDate()));
        //employeeDTOEdit.isStatus()
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

    public void deleteEmployee(Long id){employeeRepository.deleteById(id);}



//    @SneakyThrows
//    public String addImageEmployee(MultipartFile file,Long id) {
//        Path path = Path.of(file.getOriginalFilename());
//        try {
//            minioService.upload(path, file.getInputStream(), file.getContentType());
//            EmployeeModel employeeModel = employeeRepository.findById(Long.valueOf(id)).get();
//            employeeModel.setImage(file.getOriginalFilename());
//        } catch (MinioException e) {
//            throw new IllegalStateException("The file cannot be upload on the internal storage. Please retry later", e);
//        } catch (IOException e) {
//            throw new IllegalStateException("The file cannot be read", e);
//        }
//        return "success";
//    }
}
