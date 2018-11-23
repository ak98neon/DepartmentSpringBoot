package com.ak98neon.departmentspringboot.controller.employee;

import com.ak98neon.departmentspringboot.entity.Employee;
import com.ak98neon.departmentspringboot.service.employee.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    @Autowired
    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listEmployee/{id}")
    public String listEmployee(@PathVariable("id") Long id, ModelMap modelMap) {
        List<Employee> employeeList = employeeService.findAllByDepartmentId(id);
        modelMap.addAttribute("employee", employeeList);
        return "/employee/listEmployee";
    }
}
