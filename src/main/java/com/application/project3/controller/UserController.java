package com.application.project3.controller;

import com.application.project3.entities.UserMain;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.application.project3.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "success", required = false) Integer success) {
        if(success == null){
            return "collegesystem/login";
        }

        if (success == 1) {
            model.addAttribute("success", "User successfully registered. Login to continue ");
            return "collegesystem/login";
        }if(success == 2){
            model.addAttribute("success", "Password successfully changed");
            return "collegesystem/login";
        }
        return "collegesystem/login";
    }


}


