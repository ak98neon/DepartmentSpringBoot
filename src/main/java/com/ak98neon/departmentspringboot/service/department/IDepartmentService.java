package com.ak98neon.departmentspringboot.service.department;

import com.ak98neon.departmentspringboot.entity.Department;

import java.util.List;

public interface IDepartmentService {
    void saveDepartment(final Department department);

    void editDepartmentById(final Long id, final String name);

    void deleteDepartmentById(final Long id);

    Department findAllByDepartmentId(final Long id);

    List<Department> getAllDepartment();
}
