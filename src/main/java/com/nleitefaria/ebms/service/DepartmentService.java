package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Departments;
import com.nleitefaria.ebms.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Departments> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Departments> findById(String deptNo) {
        return departmentRepository.findById(deptNo);
    }

    @Transactional
    public Departments save(Departments department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public void deleteById(String deptNo) {
        departmentRepository.deleteById(deptNo);
    }
}
