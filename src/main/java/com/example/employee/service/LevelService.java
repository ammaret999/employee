package com.example.employee.service;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.LevelDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.LevelModel;
import com.example.employee.repository.GenderRepository;
import com.example.employee.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    public LevelModel createLevel(LevelDTO levelDTO){
        LevelModel levelModel = new LevelModel();
        levelModel.setCode(generate());
        levelModel.setLevel(levelDTO.getLevel());
        return levelRepository.save(levelModel);
    }

    public String generate() {
        return "L-" + UUID.randomUUID().toString().substring(0, 8);
    }


    public List<LevelModel> getLevel(){
        return levelRepository.findAll();
    }

    public void deleteLevel(Long id){levelRepository.deleteById(id);}
}
