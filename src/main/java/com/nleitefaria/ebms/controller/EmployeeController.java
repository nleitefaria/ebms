package com.nleitefaria.ebms.controller;

import com.nleitefaria.ebms.repository.EmployeeRepository;
import com.nleitefaria.ebms.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/firstName")
    public List<Employees> findByFirstName() {
        return employeeRepository.findByFirstName("Georgi");
    }

}
