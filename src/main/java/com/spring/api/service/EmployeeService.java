package com.spring.api.service;

import com.spring.api.employee.Employee;

import java.util.List;

public interface EmployeeService{

    List<Employee> getEmployees();
    void newEmployee(Employee employee);
}
