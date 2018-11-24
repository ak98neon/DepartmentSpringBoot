package com.ak98neon.departmentspringboot.service.department;

import com.ak98neon.departmentspringboot.entity.Department;

import java.util.List;

public interface IDepartmentService {
    /**
     * Save Department in database
     *
     * @param department Department object
     */
    void saveDepartment(final Department department);

    /**
     * Edit department by id
     *
     * @param id   Long department id
     * @param name String name department
     */
    void editDepartmentById(final Long id, final String name);

    /**
     * Delete department by id
     *
     * @param id Long department id
     */
    void deleteDepartmentById(final Long id);

    /**
     * Find all Departments by id
     *
     * @param id Long id department
     * @return Department object
     */
    Department findAllByDepartmentId(final Long id);

    /**
     * Find all departments
     *
     * @return List Departments
     */
    List<Department> getAllDepartment();
}
