package com.nleitefaria.ebms;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @Column(name = "emp_no", nullable = false)
    private Integer empNo;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;

    @Column(name = "gender", nullable = false, columnDefinition = "ENUM('M','F')")
    private String gender;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    protected Employees() {
        // Required by JPA
    }

    public Employees(
            Integer empNo,
            LocalDate birthDate,
            String firstName,
            String lastName,
            String gender,
            LocalDate hireDate) {
        this.empNo = empNo;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}