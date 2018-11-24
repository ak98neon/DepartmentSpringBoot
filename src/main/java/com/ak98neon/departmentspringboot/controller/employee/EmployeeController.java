package com.ak98neon.departmentspringboot.controller.employee;

import com.ak98neon.departmentspringboot.entity.Employee;
import com.ak98neon.departmentspringboot.service.employee.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeServiceImpl employeeService;
    private static final String REDIRECT_LIST_EMPLOYEE = "redirect:/listEmployee";

    @Autowired
    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/listEmployee/{id}")
    public String listEmployee(@PathVariable("id") final Long id, ModelMap modelMap) {
        List<Employee> employeeList = employeeService.findAllByDepartmentId(id);
        modelMap.addAttribute("employee", employeeList);
        modelMap.addAttribute("depId", id);
        return "/employee/listEmployee";
    }

    @GetMapping("/addEmployee/{id}")
    public String addDepartment(@PathVariable("id") final Long id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "/employee/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String saveDepartment(@RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName,
                                 @RequestParam("age") final int age, @RequestParam("mail") final String mail,
                                 @RequestParam("depId") final Long departmentId) {
        employeeService.saveEmployee(new Employee(firstName, lastName, age, mail, departmentId));
        return REDIRECT_LIST_EMPLOYEE;
    }

    @GetMapping("/editEmployee/{id}")
    public String editDepartment(@PathVariable("id") final Long id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "/employee/editEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployeeById(id);
        return REDIRECT_LIST_EMPLOYEE + "{id}";
    }
}
