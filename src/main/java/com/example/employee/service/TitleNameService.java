package com.example.employee.service;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.PositionModel;
import com.example.employee.model.TitleNameModel;
import com.example.employee.repository.GenderRepository;
import com.example.employee.repository.TitleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TitleNameService {
    @Autowired
    TitleNameRepository titleNameRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public TitleNameModel createTitleName(TitleNameDTO titleNameDTO){
        TitleNameModel titleNameModel = new TitleNameModel();
        titleNameModel.setCode(generateCode());
        titleNameModel.setTitleName(titleNameDTO.getTitleName());
        return titleNameRepository.save(titleNameModel);
    }

    public String generateCode() {
        String sql = "SELECT nextval('title_name_id_seq')";
        int seq = jdbcTemplate.queryForObject(sql, Integer.class);
        String code = "TN-" + (seq + 1);
        return code;
    }

    public List<TitleNameModel> getTitleName(){
        return titleNameRepository.findAll();
    }

    public void deleteTitleName(String query){
        TitleNameModel titleNameModel = titleNameRepository.findByCode(query);
        titleNameRepository.deleteById(titleNameModel.getId());
    }
}
