package com.application.project3.controller;

import com.application.project3.entities.RegisterForm;
import com.application.project3.entities.UserMain;
import com.application.project3.repository.UserRepository;
import com.application.project3.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {

    UserRepository userRepo;

    @Autowired
    SecurityConfig securityConfig;

    public RegisterController( UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "/collegesystem/register";
    }

    @PostMapping("/register")
    public String saveStudent(RegisterForm registerForm, UserMain userMain){
        UserMain userMain1 = new UserMain();
        userMain1.setUserId(registerForm.getUserId());
        userMain1.setPassword(securityConfig.encoder().encode(registerForm.getPassword()));
        userMain1.setRole("ROLE_STUDENT");
        userMain1.setName(registerForm.getName());
        userMain1.setAge(registerForm.getAge());
        userMain1.setPetName(registerForm.getPetName());
        userMain1.setGender(registerForm.getGender());
        userMain1.setDepartment(registerForm.getDepartment());
        userMain1.setSemester(registerForm.getSemester());


        userMain1 = userRepo.save(userMain1);

        return "redirect:/login";
    }



}
