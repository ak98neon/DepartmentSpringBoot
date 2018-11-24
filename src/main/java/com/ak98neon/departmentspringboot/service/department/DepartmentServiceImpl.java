package com.ak98neon.departmentspringboot.service.department;

import com.ak98neon.departmentspringboot.entity.Department;
import com.ak98neon.departmentspringboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    private DepartmentRepository departmentRepository;

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void saveDepartment(final Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void editDepartmentById(final Long id, final String name) {
        Department department = departmentRepository.getOne(id);
        department.setName(name);
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void deleteDepartmentById(final Long id) {
        departmentRepository.deleteDepartmentById(id);
    }

    @Override
    public Department findAllByDepartmentId(final Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
