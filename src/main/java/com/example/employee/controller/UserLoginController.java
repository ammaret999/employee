package com.example.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserLoginController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "Success login";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Principal user(Principal principal){
        System.out.println("username :" + principal.getName());
        return principal;
    }
}
