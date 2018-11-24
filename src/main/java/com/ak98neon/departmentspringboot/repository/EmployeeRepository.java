package com.ak98neon.departmentspringboot.repository;

import com.ak98neon.departmentspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartmentId(final long departmentId);

    void deleteEmployeeById(final Long id);
}
