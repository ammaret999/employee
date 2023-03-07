package com.example.employee.service;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.LevelDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.model.GenderModel;
import com.example.employee.model.LevelModel;
import com.example.employee.repository.GenderRepository;
import com.example.employee.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public LevelModel createLevel(LevelDTO levelDTO){
        LevelModel levelModel = new LevelModel();
        levelModel.setCode(generateCode());
        levelModel.setLevel(levelDTO.getLevel());
        return levelRepository.save(levelModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('level_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "L-" + (seq + 1);
        return code;
    }

    public List<LevelModel> getLevel(){
        return levelRepository.findAll();
    }

    public void deleteLevel(String query){
        LevelModel levelModel = levelRepository.findByCode(query);
        levelRepository.deleteById(levelModel.getId());
    }
}
