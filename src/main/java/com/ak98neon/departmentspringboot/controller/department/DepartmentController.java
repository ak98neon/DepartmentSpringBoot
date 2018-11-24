package com.ak98neon.departmentspringboot.controller.department;

import com.ak98neon.departmentspringboot.entity.Department;
import com.ak98neon.departmentspringboot.service.department.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {
    private DepartmentServiceImpl departmentService;
    private static final String REDIRECT_LIST_DEPARTMENT = "redirect:/listDepartment";

    @Autowired
    public void setDepartmentService(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/listDepartment")
    public String listDepartment(ModelMap modelMap) {
        List<Department> listDepartment = departmentService.getAllDepartment();
        modelMap.addAttribute("department", listDepartment);
        return "/department/listDepartment";
    }

    @GetMapping("/addDepartment")
    public String addDepartment(ModelMap modelMap) {
        return "/department/addDepartment";
    }

    @PostMapping("/addDepartment")
    public String saveDepartment(@RequestParam(value = "name") String name) {
        departmentService.saveDepartment(new Department(name));
        return REDIRECT_LIST_DEPARTMENT;
    }

    @GetMapping("/editDepartment/{id}")
    public String editDepartment(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("id", id);
        return "/department/editDepartment";
    }

    @PostMapping("/editDepartment")
    public String saveEditDepartment(@RequestParam("id") Long id, @RequestParam(value = "name") String name) {
        departmentService.editDepartmentById(id, name);
        return REDIRECT_LIST_DEPARTMENT;
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
        return REDIRECT_LIST_DEPARTMENT;
    }
}
