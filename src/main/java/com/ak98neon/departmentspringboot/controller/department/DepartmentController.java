package com.ak98neon.departmentspringboot.controller.department;

import com.ak98neon.departmentspringboot.entity.Department;
import com.ak98neon.departmentspringboot.service.department.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DepartmentController {
    private DepartmentServiceImpl departmentService;

    @Autowired
    public void setDepartmentService(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/listDepartment")
    public String listDepartment(ModelMap modelMap) {
        List<Department> listDepartment = departmentService.getAllDepartment();
        modelMap.addAttribute("department", listDepartment);
        return "listDepartment";
    }
}
