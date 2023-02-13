package com.example.employee.service;

import com.example.employee.dtoIn.EducationHistoryDTO;
import com.example.employee.model.EducationHistoryModel;
import com.example.employee.repository.EducationHistoryRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public EducationHistoryModel createEducationHistory(EducationHistoryDTO educationHistoryDTO){
        EducationHistoryModel educationHistoryModel = new EducationHistoryModel();
        educationHistoryModel.setEmployeeId(employeeRepository.findById(educationHistoryDTO.getEmployeeId()).orElse(null));
        educationHistoryModel.setLevelId(levelRepository.findById(educationHistoryDTO.getLevelId()).orElse(null));
        educationHistoryModel.setInstitution(educationHistoryDTO.getInstitution());
        educationHistoryModel.setDescription(educationHistoryDTO.getDescription());
        return educationHistoryRepository.save(educationHistoryModel);
    }

    public List<EducationHistoryModel> getEducationHistory(){
        return educationHistoryRepository.findAll();
    }

    public void deleteEducationHistory(Long id){educationHistoryRepository.deleteById(id);}
}
