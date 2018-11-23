package com.ak98neon.departmentspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first", nullable = false)
    private String first;
    @Column(name = "last")
    private String last;
    @Column(name = "age")
    private int age;
    @Column(name = "mail")
    private String mail;
    @Column(name = "depid", nullable = false)
    private Long depid;

    public Employee(String firstName, String lastName, int age, String mail, Long departmentId) {
        this.first = firstName;
        this.last = lastName;
        this.age = age;
        this.mail = mail;
        this.depid = departmentId;
    }
}