package com.example.employee.service;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.EmployeeModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.HistoryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryWorkService {
    @Autowired
    HistoryWorkRepository historyWorkRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public HistoryWorkModel createHistoryWork(HistoryWorkDTO historyWorkDTO,String query){
        HistoryWorkModel historyWorkModel = new HistoryWorkModel();
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        historyWorkModel.setCode(generateCode());
        historyWorkModel.setEmployeeId(employeeModel);
        historyWorkModel.setCompanyName(historyWorkDTO.getCompanyName());
        historyWorkModel.setStartWork(historyWorkDTO.getStartWork());
        historyWorkModel.setEndWork(historyWorkDTO.getEndWork());
        historyWorkModel.setDescription(historyWorkDTO.getDescription());
        return historyWorkRepository.save(historyWorkModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('work_history_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "WH-" + (seq + 1);
        return code;
    }

    public List<HistoryWorkModel> getHistoryWork(){
        return historyWorkRepository.findAll();
    }

    public void deleteHistoryWork(String query){
        HistoryWorkModel historyWorkModel = historyWorkRepository.findByCode(query);
        historyWorkRepository.deleteById(historyWorkModel.getId());
    }

    public List<HistoryWorkModel> getHistoryWorkByEmployee(String query) {
        EmployeeModel employeeModel = employeeRepository.findByCode(query);
        List<HistoryWorkModel> historyWorkModelList = historyWorkRepository.findAllByEmployeeId(employeeModel);
        return historyWorkModelList;
    }

    public HistoryWorkModel getHistoryWorkByCode(String query) {
        HistoryWorkModel historyWorkModel = historyWorkRepository.findByCode(query);
        return historyWorkModel;
    }

    public HistoryWorkModel editHistoryWork(HistoryWorkDTO historyWorkDTO, String query) {
        HistoryWorkModel historyWorkModel = historyWorkRepository.findByCode(query);
        historyWorkModel.setCompanyName(historyWorkDTO.getCompanyName());
        historyWorkModel.setStartWork(historyWorkDTO.getStartWork());
        historyWorkModel.setEndWork(historyWorkDTO.getEndWork());
        historyWorkModel.setDescription(historyWorkDTO.getDescription());
        return historyWorkRepository.save(historyWorkModel);
    }
}
