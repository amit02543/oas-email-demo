package com.kunal.oas_email.repository;

import com.kunal.oas_email.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByUserId(String userId);

}
