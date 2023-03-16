package com.example.employee.controller;

import com.example.employee.dtoIn.DepartmentDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/admin/department",method = RequestMethod.POST)
    public DepartmentModel createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }

    @RequestMapping(value = "/admin/department",method = RequestMethod.GET)
    public List<DepartmentModel> getDepartment(){return departmentService.getDepartment();}

    @RequestMapping(value="/admin/department/{query}", method=RequestMethod.DELETE)
    public void deleteDepartment(@PathVariable(value = "query") String query) {
        departmentService.deleteDepartment(query);
    }
}
