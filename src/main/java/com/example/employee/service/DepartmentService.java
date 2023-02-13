package com.example.employee.service;

import com.example.employee.dtoIn.DepartmentDTO;
import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.model.PositionModel;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public DepartmentModel createDepartment(DepartmentDTO departmentDTO){
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setCode(generate());
        departmentModel.setDepartment(departmentDTO.getDepartment());
        return departmentRepository.save(departmentModel);
    }

    public String generate() {
        return "D-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public List<DepartmentModel> getDepartment(){
        return departmentRepository.findAll();
    }

    public void deleteDepartment(Long id){departmentRepository.deleteById(id);}
}
