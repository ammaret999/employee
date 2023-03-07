package com.example.employee.service;

import com.example.employee.dtoIn.DepartmentDTO;
import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.model.PositionModel;
import com.example.employee.model.TitleNameModel;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public DepartmentModel createDepartment(DepartmentDTO departmentDTO){
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setCode(generateCode());
        departmentModel.setDepartment(departmentDTO.getDepartment());
        return departmentRepository.save(departmentModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('department_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "D-" + (seq + 1);
        return code;
    }

    public List<DepartmentModel> getDepartment(){
        return departmentRepository.findAll();
    }

    public void deleteDepartment(String query){
        DepartmentModel departmentModel = departmentRepository.findByCode(query);
        departmentRepository.deleteById(departmentModel.getId());
    }
}
