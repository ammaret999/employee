package com.example.employee.service;

import com.example.employee.dtoIn.DepartmentDTO;
import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.model.DepartmentModel;
import com.example.employee.model.GenderModel;
import com.example.employee.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenderService {
    @Autowired
    GenderRepository genderRepository;

    public GenderModel createGender(GenderDTO genderDTO){
        GenderModel genderModel = new GenderModel();
        genderModel.setCode(generate());
        genderModel.setGender(genderDTO.getGender());
        return genderRepository.save(genderModel);
    }

    public String generate() {
        return "G-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public List<GenderModel> getGender(){
        return genderRepository.findAll();
    }

    public void deleteGender(Long id){genderRepository.deleteById(id);}
}
