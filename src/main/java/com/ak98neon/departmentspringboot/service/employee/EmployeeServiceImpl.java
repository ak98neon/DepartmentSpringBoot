package com.ak98neon.departmentspringboot.service.employee;

import com.ak98neon.departmentspringboot.entity.Employee;
import com.ak98neon.departmentspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployeeById(Long id, String firstName, String lastName, int age, String mail) {
        Employee employee = employeeRepository.getOne(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setMail(mail);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public Employee selectEmployeeById(Long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public List<Employee> selectAllEmployeeByDepartmentId(Long depId) {
        return employeeRepository.findAll();
    }
}
