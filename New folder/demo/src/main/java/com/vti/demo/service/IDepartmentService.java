package com.vti.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;

public interface IDepartmentService {

    Page<Department> getAllDepartments(Pageable pageable);

    Department findDepartmentByID(int departmentID);

    void createDeaprtment(CreatingDepartmentForm creatingDepartmentForm);

    void updateDepartment(UpdatingDepartmentForm updatingDepartmentForm);
}
