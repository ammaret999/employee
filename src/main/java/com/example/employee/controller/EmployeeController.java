package com.example.employee.controller;

import com.example.employee.dtoEdit.EmployeeDTOEdit;
import com.example.employee.dtoIn.EmployeeDTO;
import com.example.employee.model.EmployeeModel;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public EmployeeModel createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createEmployee(employeeDTO);
    }

    @RequestMapping(value = "/employee/{query}",method = RequestMethod.PUT)
    public EmployeeModel editEmployee(@PathVariable String query,@RequestBody EmployeeDTOEdit employeeDTOEdit){
        return employeeService.editEmployee(employeeDTOEdit,query);
    }

    @RequestMapping(value = "/employee/{code}",method = RequestMethod.GET)
    public EmployeeModel getEmployeeByCode(@PathVariable String code){
        return employeeService.getEmployeeByCode(code);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public List<EmployeeModel> getEmployee(){return employeeService.getEmployee();}

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<EmployeeModel> searchEmployee(@RequestParam String query){
        return employeeService.searchEmployee(query);
    }

    @RequestMapping(value="/employee/{query1}", method=RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable String query1) {
        employeeService.deleteEmployee(query1);
    }

}
