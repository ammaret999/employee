package com.example.employee.controller;

import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserLoginController {
    @RequestMapping(value = "/token",method = RequestMethod.GET)
    public Principal user(Principal principal){
        return principal;
    }
}
