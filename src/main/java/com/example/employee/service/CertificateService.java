package com.example.employee.service;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.EmployeeModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.repository.CertificateRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.HistoryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    @Autowired
    CertificateRepository certificateRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CertificateModel createCertificate(CertificateDTO certificateDTO,String query){
        CertificateModel certificateModel = new CertificateModel();
        EmployeeModel employeeModel = employeeRepository.findByCode(query);

        certificateModel.setEmployeeId(employeeModel);
        certificateModel.setCode(generateCode());
        certificateModel.setTopic(certificateDTO.getTopic());
        certificateModel.setDescription(certificateDTO.getDescription());
        return certificateRepository.save(certificateModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('certificate_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "C-" + (seq + 1);
        return code;
    }

    public List<CertificateModel> getCertificate(){
        return certificateRepository.findAll();
    }

    public void deleteCertificate(String query){
        CertificateModel certificateModel = certificateRepository.findByCode(query);
        certificateRepository.deleteById(certificateModel.getId());
    }

    public List<CertificateModel> getCertificateByEmployee(String query) {
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        List<CertificateModel> certificateModelList = certificateRepository.findAllByEmployeeId(employeeModel);
        return certificateModelList;
    }

}
