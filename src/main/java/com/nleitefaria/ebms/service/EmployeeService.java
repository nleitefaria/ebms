package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Employees;
import com.nleitefaria.ebms.event.EmployeeEvent;
import com.nleitefaria.ebms.repository.EmployeeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApplicationEventPublisher eventPublisher;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            ApplicationEventPublisher eventPublisher) {
        this.employeeRepository = employeeRepository;
        this.eventPublisher = eventPublisher;
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
        Employees savedEmployee = employeeRepository.save(employee);
        eventPublisher.publishEvent(EmployeeEvent.saved(savedEmployee.getEmpNo()));
        return savedEmployee;
    }

    @Transactional
    public void deleteById(Integer empNo) {
        employeeRepository.deleteById(empNo);
        eventPublisher.publishEvent(EmployeeEvent.deleted(empNo));
    }
}
