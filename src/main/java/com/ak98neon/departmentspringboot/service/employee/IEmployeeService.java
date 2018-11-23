package com.ak98neon.departmentspringboot.service.employee;

import com.ak98neon.departmentspringboot.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    void saveEmployee(final Employee employee);

    void editEmployeeById(final Long id, String firstName, String lastName, int age, String mail);

    void deleteEmployeeById(final Long id);

    Employee selectEmployeeById(final Long id);

    List<Employee> selectAllEmployeeByDepartmentId(final Long depId);
}
