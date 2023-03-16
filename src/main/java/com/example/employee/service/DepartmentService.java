package com.example.employee.service;

import com.example.employee.dtoIn.DepartmentDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
