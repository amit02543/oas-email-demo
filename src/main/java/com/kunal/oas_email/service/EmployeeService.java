package com.kunal.oas_email.service;

import com.kunal.oas_email.model.Employee;
import com.kunal.oas_email.model.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> fetchAllUsers();

    Optional<Employee> fetchByEmployeeId(String empId);

    Employee createEmployee(EmployeeDto employeeDto);

    void deleteByEmployeeId(String empId);

}
