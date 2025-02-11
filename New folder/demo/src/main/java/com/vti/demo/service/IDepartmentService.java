package com.vti.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.demo.entity.Department;

public interface IDepartmentService {

    // List<Department> getAllDepartments();

    Page<Department> getAllDepartments(Pageable pageable);

    Department findDepartmentByID(int departmentID);

    // Department findDepartmentByName(String departmentName);

    Department insertDepartment(Department department);

    void deleteDepartmentByID(int departmentID);

    Department updateDepartment(int departmentID, Department department);
}
