package com.application.project3.controller;

import com.application.project3.entities.ForgotPasswordForm;
import com.application.project3.entities.RegisterForm;
import com.application.project3.entities.UserMain;
import com.application.project3.repository.UserRepository;
import com.application.project3.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordController {

    UserRepository userRepository;

    public ForgotPasswordController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    SecurityConfig securityConfig;

    @GetMapping("/forgotpassword")
    public String forgotPassword(){
        return "collegesystem/forgotpassword";
    }

    @PostMapping("/forgotpassword")
    public String validateUser(Model model, ForgotPasswordForm forgot, UserMain userMain){
        UserMain userMain1 = userRepository.findByUserIdAndPetName(userMain.getUserId(),userMain.getPetName());
        userMain1.setPassword(securityConfig.encoder().encode(userMain1.getPassword()));
        userRepository.save(userMain1);

        return "redirect:/forgotpassword";
    }

}
