package com.example.employee.service;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService {
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public GenderModel createGender(GenderDTO genderDTO){
        GenderModel genderModel = new GenderModel();
        genderModel.setCode(generateCode());
        genderModel.setGender(genderDTO.getGender());
        return genderRepository.save(genderModel);
    }

    public GenderModel editGender(GenderDTO genderDTO,String query){
        GenderModel genderModel = genderRepository.findByCode(query);
        genderModel.setGender(genderDTO.getGender());
        return genderRepository.save(genderModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('gender_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "G-" + (seq + 1);
        return code;
    }
    public List<GenderModel> getGender(){
        return genderRepository.findAll();
    }

    public GenderModel getGenderById(String query){
        GenderModel genderModel = genderRepository.findByCode(query);
        return genderModel;
    }

    public void deleteGender(String query){
        GenderModel genderModel = genderRepository.findByCode(query);
        genderRepository.deleteById(genderModel.getId());
    }
}
