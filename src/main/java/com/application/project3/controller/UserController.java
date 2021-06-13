package com.application.project3.controller;

import com.application.project3.entities.UserMain;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.application.project3.repository.UserRepository;

@Controller
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }



    @GetMapping("/login")
    public String login(){
        return "collegesystem/login";
    }



}
