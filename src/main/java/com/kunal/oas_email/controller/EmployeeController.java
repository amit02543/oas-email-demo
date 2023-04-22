package com.kunal.oas_email.controller;

import com.kunal.oas_email.exception.OasException;
import com.kunal.oas_email.model.Employee;
import com.kunal.oas_email.model.EmployeeDto;
import com.kunal.oas_email.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Employee Controller", description = "Employee controller contains APIs for employee management")
@CrossOrigin
@Slf4j
@RequestMapping("/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;


    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all employees",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) })
    })
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Employee>> fetchAllEmployees() {
        return new ResponseEntity<>(employeeService.fetchAllUsers(), HttpStatus.OK);
    }


    @Operation(summary = "Get an employee by employee id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the employee",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid employee id passed",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @RequestMapping(
            value = "/{empId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Employee> fetchByEmployeeId(@PathVariable String empId) {

        Optional<Employee> optionalEmployee = employeeService.fetchByEmployeeId(empId);


        if(!optionalEmployee.isPresent()) {
            throw new OasException("Employee with id: " + empId + " is not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
    }



    @Operation(summary = "Add a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid values passed",
                    content = @Content)
    })
    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Employee> createEmployee(EmployeeDto employeeDto) {
        log.info("Employee DTO: {}", employeeDto);
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }



    @Operation(summary = "Delete an employee by employee id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee data deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class)) }),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @RequestMapping(
            value = "/{empId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> deleteByEmployeeId(@PathVariable String empId) {

        employeeService.deleteByEmployeeId(empId);

        return new ResponseEntity<>("Employee data deleted successfully", HttpStatus.OK);
    }



}
