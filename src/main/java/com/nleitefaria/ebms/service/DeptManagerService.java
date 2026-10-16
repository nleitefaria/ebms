package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.DeptManager;
import com.nleitefaria.ebms.repository.DeptManagerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DeptManagerService {

    private final DeptManagerRepository deptManagerRepository;

    public DeptManagerService(DeptManagerRepository deptManagerRepository) {
        this.deptManagerRepository = deptManagerRepository;
    }

    public List<DeptManager> findAll() {
        return deptManagerRepository.findAll();
    }

    public Optional<DeptManager> findById(DeptManager.Id id) {
        return deptManagerRepository.findById(id);
    }

    @Transactional
    public DeptManager save(DeptManager deptManager) {
        return deptManagerRepository.save(deptManager);
    }

    @Transactional
    public void deleteById(DeptManager.Id id) {
        deptManagerRepository.deleteById(id);
    }
}
