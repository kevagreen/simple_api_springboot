package com.spring.api.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Employee(String firstName, String lastName, String email, LocalDate dob, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
}
