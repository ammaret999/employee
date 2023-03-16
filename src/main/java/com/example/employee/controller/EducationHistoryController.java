package com.example.employee.controller;

import com.example.employee.dtoIn.EducationHistoryDTO;
import com.example.employee.model.EducationHistoryModel;
import com.example.employee.service.EducationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationHistoryController {
    @Autowired
    EducationHistoryService educationHistoryService;

    @RequestMapping(value = "/education/{query}",method = RequestMethod.POST)
    public EducationHistoryModel createEducationHistory(@RequestBody EducationHistoryDTO educationHistoryDTO,@PathVariable String query){
        return educationHistoryService.createEducationHistory(educationHistoryDTO,query);
    }

    @RequestMapping(value = "/education",method = RequestMethod.GET)
    public List<EducationHistoryModel> getCertificateAll(){return educationHistoryService.getEducationHistory();}

    @RequestMapping(value = "/education/{query}",method = RequestMethod.GET)
    public List<EducationHistoryModel> getCertificateByEmployee(@PathVariable String query){return educationHistoryService.getEducationHistoryByEmployee(query);}

    @RequestMapping(value="/education/{query}", method=RequestMethod.DELETE)
    public void deleteCertificate(@PathVariable(value = "query") String query) {
        educationHistoryService.deleteEducationHistory(query);
    }
}
