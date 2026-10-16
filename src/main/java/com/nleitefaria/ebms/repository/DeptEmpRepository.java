package com.nleitefaria.ebms.repository;

import com.nleitefaria.ebms.entity.DeptEmp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmp.Id> {
}
