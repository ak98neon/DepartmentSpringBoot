package com.ak98neon.departmentspringboot.service.employee;

import com.ak98neon.departmentspringboot.entity.Employee;
import com.ak98neon.departmentspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(final Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployeeById(final Long id, final String firstName, final String lastName, final int age, final String mail) {
        Employee employee = employeeRepository.getOne(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setMail(mail);
        employeeRepository.saveAndFlush(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(final Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee selectEmployeeById(final Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> findAllByDepartmentId(final Long depId) {
        return employeeRepository.findAllByDepartmentId(depId);
    }
}
