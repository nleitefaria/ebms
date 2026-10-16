package com.nleitefaria.ebms.service;

import com.nleitefaria.ebms.entity.Salaries;
import com.nleitefaria.ebms.repository.SalaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SalaryService {

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public List<Salaries> findAll() {
        return salaryRepository.findAll();
    }

    public Optional<Salaries> findById(Salaries.Id id) {
        return salaryRepository.findById(id);
    }

    @Transactional
    public Salaries save(Salaries salary) {
        return salaryRepository.save(salary);
    }

    @Transactional
    public void deleteById(Salaries.Id id) {
        salaryRepository.deleteById(id);
    }
}
