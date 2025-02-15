package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }
}
