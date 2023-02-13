package com.example.employee.controller;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.LevelDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.LevelModel;
import com.example.employee.service.GenderService;
import com.example.employee.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {
    @Autowired
    LevelService levelService;

    @RequestMapping(value = "/admin/level",method = RequestMethod.POST)
    public LevelModel createGender(@RequestBody LevelDTO levelDTO){
        return levelService.createLevel(levelDTO);
    }

    @RequestMapping(value = "/admin/level",method = RequestMethod.GET)
    public List<LevelModel> getGender(){return levelService.getLevel();}

    @RequestMapping(value="/admin/level/{id}", method=RequestMethod.DELETE)
    public void deleteGender(@PathVariable(value = "id") Long id) {
        levelService.deleteLevel(id);
    }
}
