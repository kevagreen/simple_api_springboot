package com.spring.api.service;

import com.spring.api.employee.Employee;
import com.spring.api.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();

    }

    public void newEmployee(Employee employee){
        Optional<Employee> studentOptional = employeeRepository.findByEmail(employee.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("email already taken");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        if (!employeeRepository.existsById(id)){
            throw new IllegalStateException("employee id " + id + "does not exist");
        }
        employeeRepository.deleteById(id);
    }
}
