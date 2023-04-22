package com.kunal.oas_email.service.impl;

import com.kunal.oas_email.exception.OasException;
import com.kunal.oas_email.model.Employee;
import com.kunal.oas_email.model.EmployeeDto;
import com.kunal.oas_email.repository.EmployeeRepository;
import com.kunal.oas_email.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> fetchAllUsers() {
        return employeeRepository.findAll();
    }


    @Override
    public Optional<Employee> fetchByEmployeeId(String empId) {
        return employeeRepository.findByUserId(empId);
    }


    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(UUID.randomUUID().toString());
        employee.setUserId(employeeDto.getUserId());
        employee.setUsername(employeeDto.getUsername());
        employee.setPassword(employeeDto.getPassword());
        employee.setDeleted(false);

        return employeeRepository.save(employee);
    }


    @Override
    public void deleteByEmployeeId(String empId) {
        Optional<Employee> optionalEmployee = fetchByEmployeeId(empId);

        if(!optionalEmployee.isPresent()) {
            throw new OasException("Employee with id: " + empId + " is not found", HttpStatus.NOT_FOUND);
        }


        Employee employee = optionalEmployee.get();

        employeeRepository.deleteById(employee.getId());
    }


}
