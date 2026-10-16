package com.nleitefaria.ebms.repository;

import com.nleitefaria.ebms.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salaries, Salaries.Id> {
}
