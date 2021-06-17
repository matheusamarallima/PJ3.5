package com.application.project3.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class UserMain implements UserDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String role;
    private String name;
    private Integer age;
    private String petName;
    private String gender;
    private String department;
    private String semester;


    public UserMain() {
    }

    public UserMain(String userId, String password, String role, String name, Integer age, String petName, String gender, String department, String semester) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.name = name;
        this.age = age;
        this.petName = petName;
        this.gender = gender;
        this.department = department;
        this.semester = semester;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.asList(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMain userMain = (UserMain) o;
        return Objects.equals(id, userMain.id) && Objects.equals(userId, userMain.userId) && Objects.equals(password, userMain.password) && Objects.equals(role, userMain.role) && Objects.equals(name, userMain.name) && Objects.equals(age, userMain.age) && Objects.equals(petName, userMain.petName) && Objects.equals(gender, userMain.gender) && Objects.equals(department, userMain.department) && Objects.equals(semester, userMain.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, password, role, name, age, petName, gender, department, semester);
    }

}
