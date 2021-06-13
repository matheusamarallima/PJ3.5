package com.application.project3.controller;


import com.application.project3.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentListController {

    private UserRepository userRepository;

    public StudentListController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/studentlist")
    public String students(Model model){
        model.addAttribute("studentsList", userRepository.findAllByRole("ROLE_STUDENT"));
        return "collegesystem/studentlist";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model){

        userRepository.delete(userRepository.findById(id));
        return "redirect:/studentlist";
    }


}
