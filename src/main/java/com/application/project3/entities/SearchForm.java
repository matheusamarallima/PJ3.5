package com.application.project3.entities;

public class SearchForm {

    private String department;
    private String semester;

    public SearchForm() {
    }

    public SearchForm(String department, String semester) {
        this.department = department;
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
