package com.example.employee.controller;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.service.GenderService;
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

    @RequestMapping(value = "/admin/gender/{query}",method = RequestMethod.PUT)
    public GenderModel createGender(@RequestBody GenderDTO genderDTO,@PathVariable(value = "query") String query){
        return genderService.editGender(genderDTO,query);
    }

    @RequestMapping(value = "/admin/gender",method = RequestMethod.GET)
    public List<GenderModel> getGender(){return genderService.getGender();}

    @RequestMapping(value = "/admin/gender/{query}",method = RequestMethod.GET)
    public GenderModel getGenderById(@PathVariable(value = "query")String query){return genderService.getGenderById(query);}

    @RequestMapping(value="/admin/gender/{query}", method=RequestMethod.DELETE)
    public void deleteGender(@PathVariable(value = "query") String query) {
        genderService.deleteGender(query);
    }
}
