package com.example.employee.controller;

import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam String query){
        return employeeService.uploadFile(file,query);
    }

    @RequestMapping(value = "/file/{query}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> inputData(@PathVariable String query){
        return employeeService.getImageEmployee(query);
    }

//    @RequestMapping(value = "/etag",method = RequestMethod.GET)
//    public ResponseEntity<String> getEtag(@RequestParam String query){
//        return employeeService.getEtag(query);
//    }

}
