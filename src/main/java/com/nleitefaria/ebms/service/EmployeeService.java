package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Employees;
import com.nleitefaria.ebms.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employees> findById(Integer empNo) {
        return employeeRepository.findById(empNo);
    }

    public List<Employees> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<Employees> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public List<Employees> findByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }

    public List<Employees> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Transactional
    public Employees save(Employees employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteById(Integer empNo) {
        employeeRepository.deleteById(empNo);
    }
}
