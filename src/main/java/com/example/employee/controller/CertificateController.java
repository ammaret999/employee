package com.example.employee.controller;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CertificateController {
    @Autowired
    CertificateService certificateService;

    @RequestMapping(value = "/certificate/{query}",method = RequestMethod.POST)
    public CertificateModel createCertificate(@RequestBody CertificateDTO certificateDTO,@PathVariable String query){
        return certificateService.createCertificate(certificateDTO,query);
    }

    @RequestMapping(value = "/certificate",method = RequestMethod.GET)
    public List<CertificateModel> getCertificateAll(){return certificateService.getCertificate();}

    @RequestMapping(value = "/certificate/{query}",method = RequestMethod.GET)
    public List<CertificateModel> getCertificateByEmployee(@PathVariable String query){return certificateService.getCertificateByEmployee(query);}

    @RequestMapping(value="/certificate/{query}", method=RequestMethod.DELETE)
    public void deleteCertificate(@PathVariable String query) {
        certificateService.deleteCertificate(query);
    }
}
