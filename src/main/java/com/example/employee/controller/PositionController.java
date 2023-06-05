package com.example.employee.controller;

import com.example.employee.dtoIn.PositionDTO;
import com.example.employee.model.PositionModel;
import com.example.employee.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    PositionService positionService;

    @RequestMapping(value = "/admin/position",method = RequestMethod.POST)
    public PositionModel createPosition(@RequestBody PositionDTO positionDTO){
        return positionService.createPosition(positionDTO);
    }

    @RequestMapping(value = "/admin/position/{query}",method = RequestMethod.PUT)
    public PositionModel editPosition(@RequestBody PositionDTO positionDTO,@PathVariable(value = "query") String query){
        return positionService.editPosition(positionDTO,query);
    }

    @RequestMapping(value = "/admin/position",method = RequestMethod.GET)
    public List<PositionModel> getPosition(){return positionService.getPosition();}

    @RequestMapping(value = "/admin/position/{query}",method = RequestMethod.GET)
    public PositionModel getPositionById(@PathVariable(value = "query") String query){return positionService.getPositionById(query);}

    @RequestMapping(value="/admin/position/{query}", method=RequestMethod.DELETE)
    public void deletePosition(@PathVariable(value = "query") String query) {
        positionService.deletePosition(query);
    }
}
