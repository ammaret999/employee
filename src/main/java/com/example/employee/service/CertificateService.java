package com.example.employee.service;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.repository.CertificateRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.HistoryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    @Autowired
    CertificateRepository certificateRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public CertificateModel createCertificate(CertificateDTO certificateDTO){
        CertificateModel certificateModel = new CertificateModel();
        certificateModel.setEmployeeId(employeeRepository.findById(certificateDTO.getEmployeeId()).orElse(null));
        certificateModel.setTopic(certificateDTO.getTopic());
        certificateModel.setDescription(certificateDTO.getDescription());
        return certificateRepository.save(certificateModel);
    }

    public List<CertificateModel> getCertificate(){
        return certificateRepository.findAll();
    }

    public void deleteCertificate(Long id){certificateRepository.deleteById(id);}
}
