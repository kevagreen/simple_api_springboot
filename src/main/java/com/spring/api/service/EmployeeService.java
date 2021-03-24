package com.spring.api.service;

import com.spring.api.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService{

    List<Employee> getEmployees();
    void newEmployee(Employee employee);
    void deleteEmployee(Long id);
    public void updateEmployee(Long id, String lastName, String email);
}
