package com.application.project3.repository;

import com.application.project3.entities.Classes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassesRepository extends CrudRepository <Classes, String> {

    List<Classes> findAllByDepartmentAndSemester(String department, String Semester);




}
