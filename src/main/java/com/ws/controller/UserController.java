package com.ws.controller;

import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(Model model,String username, String password){
        boolean isSuccess = userService.login(username,password);
        if(isSuccess){
            return "index";
        }else{
            return "login";
        }
    }
    @PostMapping("register")
    public String register(String username,String password){
        boolean isSuccess = userService.register(username,password);
        if(isSuccess){
            return "redirect:/loginPage";
        }else{
            return "register";
        }
    }
}
