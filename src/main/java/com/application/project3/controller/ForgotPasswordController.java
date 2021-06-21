package com.application.project3.controller;


import com.application.project3.entities.UserMain;
import com.application.project3.entities.ValidateForm;
import com.application.project3.repository.UserRepository;
import com.application.project3.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"validateForm"})
public class ForgotPasswordController {

    UserRepository userRepository;

    public ForgotPasswordController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    SecurityConfig securityConfig;

    @GetMapping("/forgotpassword")
    public String forgotPassword(Model model, @SessionAttribute(value = "validateForm", required = false) ValidateForm validateForm) {

        if (validateForm == null) {
            validateForm = new ValidateForm();

        }

        model.addAttribute("validateForm", validateForm);

        return "collegesystem/forgotpassword";
    }

    @PostMapping("/forgotpassword")
    public String validateUser(Model model, RedirectAttributes redirectAttributes, ValidateForm validateForm,
                               @RequestParam(value = "password", required = false) String password,
                               @RequestParam(value = "confirmPassword", required = false) String confirmPassword) {


        try {
            model.addAttribute("validateForm", validateForm);
            UserMain userMain1 = userRepository.findByUserId(validateForm.getUserId());

            if (userMain1 != null && userMain1.getPetName().equals(validateForm.getPetName())) {
                return "redirect:/forgotpassword?validate=1";
            }
            if (userMain1 != null && password != null && password.equals(confirmPassword)) {

                userMain1.setPassword(securityConfig.encoder().encode(password));
                userRepository.save(userMain1);
                return "redirect:/login?success=2";

            }else{
                model.addAttribute("error", "User Id/Security answer is invalid");
                return "collegesystem/forgotpassword";
            }

        } catch (Exception e) {
            model.addAttribute("error", "User Id/Security answer is invalid");
            return "collegesystem/forgotpassword";
        }

    }

    @PostMapping("/resetpassword")
    public String reset(Model model,
                        @RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
                        @SessionAttribute("validateForm") ValidateForm validateForm) {

        if (password != null && password.equals(confirmPassword)) {
            UserMain userMain1 = userRepository.findByUserId(validateForm.getUserId());
            userMain1.setPassword(securityConfig.encoder().encode(password));
            userRepository.save(userMain1);
            return "redirect:/login?success=2";

        } else {
            model.addAttribute("error", "Password must be the same");
            return "collegesystem/forgotpassword";

        }


    }

}


