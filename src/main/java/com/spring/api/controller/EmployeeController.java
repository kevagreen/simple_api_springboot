package com.spring.api.controller;

import com.spring.api.employee.Employee;
import com.spring.api.service.EmployeeService;
import com.spring.api.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee")
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployees(){

    return employeeService.getEmployees();
    }

}
