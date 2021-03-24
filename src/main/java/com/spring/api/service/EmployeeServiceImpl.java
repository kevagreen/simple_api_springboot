package com.spring.api.service;

import com.spring.api.employee.Employee;
import com.spring.api.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
        if(!employeeRepository.existsById(id)) throw  new IllegalStateException("employee id " + id + "does not exist");
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Long id, String lastName, String email) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("employee not found with " + id));
        if (lastName != null && lastName.length() > 0 && !Objects.equals(employee.getLastName(), lastName)){
            employee.setLastName(lastName);

        }

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)){
            if (employeeOptional.isPresent()) throw new IllegalStateException("email taken");
            employee.setEmail(email);
        }
    }


}
