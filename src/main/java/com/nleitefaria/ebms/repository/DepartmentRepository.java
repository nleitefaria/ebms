package com.nleitefaria.ebms.repository;

import com.nleitefaria.ebms.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, String> {
}
