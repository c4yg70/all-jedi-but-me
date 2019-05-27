package com.example.paper.controller;

import com.example.paper.bl.LoginService;
import com.example.paper.parameter.UserParam;
import com.example.paper.response.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/userSignUp")
    public BasicResponse userSignUp(@RequestBody UserParam param){
        return loginService.userSignUp(param.getUsername(),param.getPassword());
    }

    @PostMapping(value = "/userLogin")
    public BasicResponse userLogin(@RequestBody UserParam param){
        return loginService.userLogin(param.getUsername(),param.getPassword());
    }
}
