package com.example.employee.service;

import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.dtoIn.LevelDTO;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.model.LevelModel;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.HistoryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryWorkService {
    @Autowired
    HistoryWorkRepository historyWorkRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public HistoryWorkModel createHistoryWork(HistoryWorkDTO historyWorkDTO){
        HistoryWorkModel historyWorkModel = new HistoryWorkModel();
        historyWorkModel.setEmployeeId(employeeRepository.findById(historyWorkDTO.getEmployeeId()).orElse(null));
        historyWorkModel.setCompanyName(historyWorkDTO.getCompanyName());
        historyWorkModel.setStartWork(historyWorkDTO.getStartWork());
        historyWorkModel.setEndWork(historyWorkDTO.getEndWork());
        historyWorkModel.setDescription(historyWorkDTO.getDescription());
        return historyWorkRepository.save(historyWorkModel);
    }

    public List<HistoryWorkModel> getHistoryWork(){
        return historyWorkRepository.findAll();
    }

    public void deleteHistoryWork(Long id){historyWorkRepository.deleteById(id);}
}
