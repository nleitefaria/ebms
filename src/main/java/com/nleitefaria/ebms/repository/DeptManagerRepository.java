package com.nleitefaria.ebms.repository;

import com.nleitefaria.ebms.entity.DeptManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManager.Id> {
}
