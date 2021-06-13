package com.application.project3.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Classes {

    @Id
    private String courseId;
    private String semester;
    private String department;
    private String courseName;

    public Classes() {
    }

    public Classes(String courseId, String semester, String department, String courseName) {
        this.courseId = courseId;
        this.semester = semester;
        this.department = department;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classes)) return false;
        Classes classes = (Classes) o;
        return semester == classes.semester && Objects.equals(courseId, classes.courseId) && Objects.equals(department, classes.department) && Objects.equals(courseName, classes.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, semester, department, courseName);
    }

    @Override
    public String toString() {
        return "Classes{" +
                "courseId='" + courseId + '\'' +
                ", semester=" + semester +
                ", department='" + department + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
