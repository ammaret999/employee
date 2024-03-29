package com.example.employee.controller;

import com.example.employee.dtoIn.TitleNameDTO;
import com.example.employee.model.TitleNameModel;
import com.example.employee.service.TitleNameService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class TitleNameController {
    @Autowired
    TitleNameService titleNameService;

    @RequestMapping(value = "/admin/title",method = RequestMethod.POST)
    public TitleNameModel createTitleName(@RequestBody TitleNameDTO titleNameDTO){
        return titleNameService.createTitleName(titleNameDTO);
    }

    @RequestMapping(value = "/admin/title/{query}",method = RequestMethod.PUT)
    public TitleNameModel editTitleName(@RequestBody TitleNameDTO titleNameDTO,@PathVariable(value = "query") String query){
        return titleNameService.editTitleName(titleNameDTO,query);
    }

    @RequestMapping(value = "/admin/title",method = RequestMethod.GET)
    public List<TitleNameModel> getTitleName(){return titleNameService.getTitleName();}

    @RequestMapping(value = "/admin/title/{query}",method = RequestMethod.GET)
    public TitleNameModel getTitleNameByCode(@PathVariable(value = "query") String query){return titleNameService.getTitleNameByCode(query);}

    @RequestMapping(value="/admin/title/{query}", method=RequestMethod.DELETE)
    public void deleteTitleName(@PathVariable(value = "query") String query) {
        titleNameService.deleteTitleName(query);
    }
}
