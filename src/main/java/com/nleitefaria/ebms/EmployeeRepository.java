package com.nleitefaria.ebms;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employees, Long> {

    List<Employees> findByFirstName(String firstName);

    List<Employees> findByLastName(String lastName);

    List<Employees> findByGender(String gender);

    List<Employees> findByFirstNameAndLastName(
            String firstName, String lastName);
}