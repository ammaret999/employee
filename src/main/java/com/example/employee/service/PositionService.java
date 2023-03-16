package com.example.employee.service;

import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.PositionModel;
import com.example.employee.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public PositionModel createPosition(PositionDTO positionDTO){
        PositionModel positionModel = new PositionModel();
        positionModel.setCode(generateCode());
        positionModel.setPosition(positionDTO.getPosition());
        positionModel.setSalaryMin(positionDTO.getSalaryMin());
        positionModel.setSalaryMax(positionDTO.getSalaryMax());
        return positionRepository.save(positionModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('position_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "P-" + (seq + 1);
        return code;
    }

    public List<PositionModel> getPosition(){
        return positionRepository.findAll();
    }

    public void deletePosition(String query){
        PositionModel positionModel = positionRepository.findByCode(query);
        positionRepository.deleteById(positionModel.getId());
    }
}
