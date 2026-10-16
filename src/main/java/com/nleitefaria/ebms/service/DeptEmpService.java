package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.DeptEmp;
import com.nleitefaria.ebms.repository.DeptEmpRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DeptEmpService {

    private final DeptEmpRepository deptEmpRepository;

    public DeptEmpService(DeptEmpRepository deptEmpRepository) {
        this.deptEmpRepository = deptEmpRepository;
    }

    public List<DeptEmp> findAll() {
        return deptEmpRepository.findAll();
    }

    public Optional<DeptEmp> findById(DeptEmp.Id id) {
        return deptEmpRepository.findById(id);
    }

    @Transactional
    public DeptEmp save(DeptEmp deptEmp) {
        return deptEmpRepository.save(deptEmp);
    }

    @Transactional
    public void deleteById(DeptEmp.Id id) {
        deptEmpRepository.deleteById(id);
    }
}
