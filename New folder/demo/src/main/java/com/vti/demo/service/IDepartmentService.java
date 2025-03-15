package com.vti.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.DepartmentFilterForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;

public interface IDepartmentService {

    Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm departmentFilterForm);

    Department findDepartmentByID(int departmentID);

    void createDepartment(CreatingDepartmentForm creatingDepartmentForm);

    void updateDepartment(UpdatingDepartmentForm updatingDepartmentForm);

    void deleteDepartment(int departmentID);

    boolean isDepartmentExistsByID(int departmentID);

    boolean isDepartmentExistsByName(String departmentName);

}
