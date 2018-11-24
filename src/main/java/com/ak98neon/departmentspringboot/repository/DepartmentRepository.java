package com.ak98neon.departmentspringboot.repository;

import com.ak98neon.departmentspringboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    /**
     * Delete department by id
     *
     * @param id Long department id
     */
    void deleteDepartmentById(Long id);
}
