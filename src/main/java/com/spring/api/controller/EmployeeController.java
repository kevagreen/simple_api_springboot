package com.spring.api.controller;

import com.spring.api.employee.Employee;
import com.spring.api.service.EmployeeService;
import com.spring.api.service.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void createNewEmployee(@RequestBody Employee employee){
        employeeService.newEmployee(employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@PathVariable("id") Long id, @RequestParam(required = false) String lastName, @RequestParam(required = false) String email){
        employeeService.updateEmployee(id, lastName, email);
    }


}
