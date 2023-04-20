package com.example.employee.controller;

import com.example.employee.dtoIn.LevelDTO;
import com.example.employee.model.LevelModel;
import com.example.employee.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {
    @Autowired
    LevelService levelService;

    @RequestMapping(value = "/admin/level",method = RequestMethod.POST)
    public LevelModel createLevel(@RequestBody LevelDTO levelDTO){
        return levelService.createLevel(levelDTO);
    }

    @RequestMapping(value = "/admin/level/{query}",method = RequestMethod.PUT)
    public LevelModel putLevel(@RequestBody LevelDTO levelDTO,@PathVariable(value = "query")String query){
        return levelService.editLevel(levelDTO,query);
    }

    @RequestMapping(value = "/admin/level",method = RequestMethod.GET)
    public List<LevelModel> getLevel(){return levelService.getLevel();}

    @RequestMapping(value = "/admin/level/{query}",method = RequestMethod.GET)
    public LevelModel getLevelById(@PathVariable(value = "query")String query){
        return levelService.getLevelByCode(query);
    }

    @RequestMapping(value="/admin/level/{query}", method=RequestMethod.DELETE)
    public void deleteLevel(@PathVariable(value = "query") String query) {
        levelService.deleteLevel(query);
    }
}
