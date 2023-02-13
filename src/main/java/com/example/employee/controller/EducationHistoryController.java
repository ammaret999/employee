package com.example.employee.controller;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.EducationHistoryDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.EducationHistoryModel;
import com.example.employee.repository.EducationHistoryRepository;
import com.example.employee.service.CertificateService;
import com.example.employee.service.EducationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationHistoryController {
    @Autowired
    EducationHistoryService educationHistoryService;

    @RequestMapping(value = "/education",method = RequestMethod.POST)
    public EducationHistoryModel createEducationHistory(@RequestBody EducationHistoryDTO educationHistoryDTO){
        return educationHistoryService.createEducationHistory(educationHistoryDTO);
    }

    @RequestMapping(value = "/education",method = RequestMethod.GET)
    public List<EducationHistoryModel> getCertificate(){return educationHistoryService.getEducationHistory();}

    @RequestMapping(value="/education/{id}", method=RequestMethod.DELETE)
    public void deleteCertificate(@PathVariable(value = "id") Long id) {
        educationHistoryService.deleteEducationHistory(id);
    }
}
