package com.example.employee.controller;

import com.example.employee.dtoIn.CertificateDTO;
import com.example.employee.dtoIn.HistoryWorkDTO;
import com.example.employee.model.CertificateModel;
import com.example.employee.model.HistoryWorkModel;
import com.example.employee.service.HistoryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class HistoryWorkController {
    @Autowired
    HistoryWorkService historyWorkService;

    @RequestMapping(value = "/work/{query}",method = RequestMethod.POST)
    public HistoryWorkModel createHistoryWork(@RequestBody HistoryWorkDTO historyWorkDTO,@PathVariable String query){
        return historyWorkService.createHistoryWork(historyWorkDTO,query);
    }

    @RequestMapping(value = "/work",method = RequestMethod.GET)
    public List<HistoryWorkModel> getHistoryWorkAll(){return historyWorkService.getHistoryWork();}

    @RequestMapping(value = "/work/employee/{query}",method = RequestMethod.GET)
    public List<HistoryWorkModel> getHistoryWorkByEmployee(@PathVariable String query){return historyWorkService.getHistoryWorkByEmployee(query);}

    @RequestMapping(value = "/work/{query}",method = RequestMethod.GET)
    public HistoryWorkModel getHistoryWorkByCode(@PathVariable String query){return historyWorkService.getHistoryWorkByCode(query);}

    @RequestMapping(value = "/work/{query}",method = RequestMethod.PUT)
    public HistoryWorkModel editHistoryWork(@RequestBody HistoryWorkDTO HistoryWorkDTO, @PathVariable String query){return historyWorkService.editHistoryWork(HistoryWorkDTO,query);}

    @RequestMapping(value="/work/{query}", method=RequestMethod.DELETE)
    public void deleteHistoryWork(@PathVariable String query) {
        historyWorkService.deleteHistoryWork(query);
    }
}
