package com.ak98neon.departmentspringboot.repository;

import com.ak98neon.departmentspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Find all Employee by department id
     *
     * @param departmentId Long department id
     * @return List Employee
     */
    List<Employee> findAllByDepartmentId(final Long departmentId);

    /**
     * Delete Employee by id
     *
     * @param id Long id
     */
    void deleteEmployeeById(final Long id);
}
