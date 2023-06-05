package com.example.employee.controller;

import com.example.employee.dtoIn.CodeLoginDTO;
import com.example.employee.service.TitleNameService;
import com.example.employee.service.UserLoginService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public String createTitleName(@RequestBody CodeLoginDTO codeLoginDTO) throws IOException {
        return userLoginService.getIdToken(codeLoginDTO);
    }

}
