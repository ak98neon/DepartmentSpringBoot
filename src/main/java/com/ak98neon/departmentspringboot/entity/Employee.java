package com.ak98neon.departmentspringboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    private String lastName;
    private int age;
    private String mail;
    private Date dateOfCreation;
    @Column(name = "departmentID", nullable = false)
    private Long departmentId;

    public Employee(Long id, String firstName, String lastName, int age, String mail, Long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.departmentId = departmentId;
    }
}
