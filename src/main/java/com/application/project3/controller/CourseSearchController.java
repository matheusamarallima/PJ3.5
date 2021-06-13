package com.application.project3.controller;

import com.application.project3.entities.Classes;
import com.application.project3.entities.RegisterForm;
import com.application.project3.entities.SearchForm;
import com.application.project3.entities.UserMain;
import com.application.project3.repository.ClassesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CourseSearchController {

    private ClassesRepository classesRepo;

    public CourseSearchController(ClassesRepository classesRepo){
        this.classesRepo = classesRepo;
    }

    @GetMapping("/coursesearch")
    public String courseSearchForm(Model model, SearchForm searchForm, Classes classes){
        Classes classes1 = new Classes();
        classes1.setDepartment(searchForm.getDepartment());
        classes1.setSemester(searchForm.getSemester());
        model.addAttribute("classesList", classesRepo.findAllByDepartmentAndSemester(classes1.getDepartment(), classes1.getSemester()));
        return "/collegesystem/coursesearch";
    }



}
