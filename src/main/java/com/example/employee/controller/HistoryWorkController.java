package com.example.employee.controller;

import com.example.employee.dtoIn.GenderDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.GenderModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.service.GenderService;
import com.example.employee.service.HistoryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class HistoryWorkController {
    @Autowired
    HistoryWorkService historyWorkService;

    @RequestMapping(value = "/work",method = RequestMethod.POST)
    public HistoryWorkModel createHistoryWork(@RequestBody HistoryWorkDTO historyWorkDTO){
        return historyWorkService.createHistoryWork(historyWorkDTO);
    }

    @RequestMapping(value = "/work",method = RequestMethod.GET)
    public List<HistoryWorkModel> getHistoryWork(){return historyWorkService.getHistoryWork();}

    @RequestMapping(value="/work/{id}", method=RequestMethod.DELETE)
    public void deleteHistoryWork(@PathVariable(value = "id") Long id) {
        historyWorkService.deleteHistoryWork(id);
    }
}
