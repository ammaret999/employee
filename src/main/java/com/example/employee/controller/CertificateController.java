package com.example.employee.controller;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.service.CertificateService;
import com.example.employee.service.HistoryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @RequestMapping(value = "/certificate",method = RequestMethod.POST)
    public CertificateModel createCertificate(@RequestBody CertificateDTO certificateDTO){
        return certificateService.createCertificate(certificateDTO);
    }

    @RequestMapping(value = "/certificate",method = RequestMethod.GET)
    public List<CertificateModel> getCertificate(){return certificateService.getCertificate();}

    @RequestMapping(value="/certificate/{id}", method=RequestMethod.DELETE)
    public void deleteCertificate(@PathVariable(value = "id") Long id) {
        certificateService.deleteCertificate(id);
    }
}
