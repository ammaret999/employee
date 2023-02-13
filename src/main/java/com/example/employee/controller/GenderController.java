package com.example.employee.controller;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.PositionModel;
import com.example.employee.service.GenderService;
import com.example.employee.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenderController {
    @Autowired
    GenderService genderService;

    @RequestMapping(value = "/admin/gender",method = RequestMethod.POST)
    public GenderModel createGender(@RequestBody GenderDTO genderDTO){
        return genderService.createGender(genderDTO);
    }

    @RequestMapping(value = "/admin/gender",method = RequestMethod.GET)
    public List<GenderModel> getGender(){return genderService.getGender();}

    @RequestMapping(value="/admin/gender/{id}", method=RequestMethod.DELETE)
    public void deleteGender(@PathVariable(value = "id") Long id) {
        genderService.deleteGender(id);
    }
}
