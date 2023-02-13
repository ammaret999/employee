package com.example.employee.service;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.TitleNameModel;
import com.example.employee.repository.GenderRepository;
import com.example.employee.repository.TitleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TitleNameService {
    @Autowired
    TitleNameRepository titleNameRepository;

    public TitleNameModel createTitleName(TitleNameDTO titleNameDTO){
        TitleNameModel titleNameModel = new TitleNameModel();
        titleNameModel.setCode(generate());
        titleNameModel.setTitleName(titleNameDTO.getTitleName());
        return titleNameRepository.save(titleNameModel);
    }

    public String generate() {
        return "TN-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public List<TitleNameModel> getTitleName(){
        return titleNameRepository.findAll();
    }

    public void deleteTitleName(Long id){titleNameRepository.deleteById(id);}
}
