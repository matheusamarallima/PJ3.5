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
    public String saveStudent(Model model, RegisterForm registerForm, UserMain userMain){

//        if(registerForm.getUserId().equals("") || registerForm.getName().equals("") || registerForm.getPetName().equals("")
//        || registerForm.getAge() == 0 || registerForm.getPassword().equals("") || registerForm.getDepartment().equals("") || registerForm.getSemester().equals("")){
//            model.addAttribute("errorMessage", "Name is mandatory \n" +
//                    "\n" +
//                    "Name must be at least 3 - 20 characters long \n" +
//                    "\n" +
//                    "Name must contain letters only \n" +
//                    "\n" +
//                    "User Id is mandatory \n" +
//                    "\n" +
//                    "User Id must be alphanumeric and should contain 6 - 10 character \n" +
//                    "\n" +
//                    "Password is mandatory \n" +
//                    "\n" +
//                    "Password must contain at least one number, one special character, one uppercase, one lowercase letter, one special char and should contain 8 - 16 characters \n" +
//                    "\n" +
//                    "Pet Name is mandatory \n" +
//                    "\n" +
//                    "Pet Name must contain letters only \n" +
//                    "\n" +
//                    "Pet Name must be at least 3 - 10 characters long \n" +
//                    "\n" +
//                    "Age is mandatory \n" +
//                    "\n" +
//                    "Age should be greater than 18 and less than 120 \n" +
//                    "\n" +
//                    "User already exists");
//            return "/collegesystem/register";
//        }
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

        return "redirect:/login?success=1";
    }



}
