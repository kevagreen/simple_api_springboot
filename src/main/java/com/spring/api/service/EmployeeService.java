package com.spring.api.service;

import com.spring.api.employee.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeService extends CrudRepository<Employee, Long> {

    List<Employee> getEmployees();
}
