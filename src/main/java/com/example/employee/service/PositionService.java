package com.example.employee.service;

import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.PositionModel;
import com.example.employee.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public PositionModel createPosition(PositionDTO positionDTO){
        PositionModel positionModel = new PositionModel();
        positionModel.setCode(generate());
        positionModel.setPosition(positionDTO.getPosition());
        positionModel.setSalaryMin(positionDTO.getSalaryMin());
        positionModel.setSalaryMax(positionDTO.getSalaryMax());
        return positionRepository.save(positionModel);
    }

    public String generate() {
        return "P-" + UUID.randomUUID().toString().substring(0, 8);
    }


    public List<PositionModel> getPosition(){
        return positionRepository.findAll();
    }

    public void deletePosition(Long id){positionRepository.deleteById(id);}
}
