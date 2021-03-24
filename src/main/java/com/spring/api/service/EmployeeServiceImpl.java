package com.spring.api.service;

import com.spring.api.employee.Employee;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> getEmployees(){
        return List.of(
                new Employee("Kim", "Jones", "kimj@email.com", LocalDate.of(2000, Month.APRIL, 25), 20)
        );
    }
}
