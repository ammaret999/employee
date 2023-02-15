package com.example.employee.controller;

import com.example.employee.dtoEdit.EmployeeDTOEdit;
import com.example.employee.dtoIn.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public EmployeeModel createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @RequestMapping(value = "/uplode",method = RequestMethod.POST)
    public void upLodeFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getResource());
        System.out.println(file.getContentType());

    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.PUT)
    public EmployeeModel editEmployee(@PathVariable(value = "id") Long id,@RequestBody EmployeeDTOEdit employeeDTOEdit){
        return employeeService.editEmployee(employeeDTOEdit,id);
    }
    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public List<EmployeeModel> getEmployee(){return employeeService.getEmployee();}

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<EmployeeModel> searchEmployee(@RequestParam String query){
        return employeeService.searchEmployee(query);
    }

    @RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
