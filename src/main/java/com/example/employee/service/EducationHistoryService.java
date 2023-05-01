package com.example.employee.service;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.EducationHistoryDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.EducationHistoryModel;
import com.example.employee.model.EmployeeModel;
import com.example.employee.repository.EducationHistoryRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationHistoryService {
    @Autowired
    EducationHistoryRepository educationHistoryRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public EducationHistoryModel createEducationHistory(EducationHistoryDTO educationHistoryDTO,String query){
        EducationHistoryModel educationHistoryModel = new EducationHistoryModel();
        educationHistoryModel.setEmployeeId(employeeRepository.findByCode(query));
        educationHistoryModel.setCode(generateCode());
        educationHistoryModel.setLevelId(levelRepository.findById(educationHistoryDTO.getLevelId()).orElse(null));
        educationHistoryModel.setInstitution(educationHistoryDTO.getInstitution());
        educationHistoryModel.setDescription(educationHistoryDTO.getDescription());
        return educationHistoryRepository.save(educationHistoryModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('education_history_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "EH-" + (seq + 1);
        return code;
    }

    public List<EducationHistoryModel> getEducationHistory(){
        return educationHistoryRepository.findAll();
    }

    public void deleteEducationHistory(String query){
        EducationHistoryModel educationHistoryModel = educationHistoryRepository.findByCode(query);
        educationHistoryRepository.deleteById(educationHistoryModel.getId());
        }

    public List<EducationHistoryModel> getEducationHistoryByEmployee(String query) {
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        List<EducationHistoryModel> educationHistoryModelList = educationHistoryRepository.findAllByEmployeeId(employeeModel);
        return educationHistoryModelList;
    }

    public EducationHistoryModel getEducationHistoryByCode(String query) {
        EducationHistoryModel educationHistoryModel = educationHistoryRepository.findByCode(query);
        return educationHistoryModel;
    }

    public EducationHistoryModel editEducationHistory(EducationHistoryDTO educationHistoryDTO, String query) {
        EducationHistoryModel educationHistoryModel = educationHistoryRepository.findByCode(query);
        educationHistoryModel.setLevelId(levelRepository.findById(educationHistoryDTO.getLevelId()).orElse(null));
        educationHistoryModel.setInstitution(educationHistoryDTO.getInstitution());
        educationHistoryModel.setDescription(educationHistoryDTO.getDescription());
        return educationHistoryRepository.save(educationHistoryModel);
    }
}
