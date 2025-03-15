package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.demo.entity.Department;

public interface IDepartmentRepository
        extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {

    boolean existsByDepartmentName(String departmentName);

    boolean existsByDepartmentID(int departmentID);
}
