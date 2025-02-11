package com.vti.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.demo.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

    // Department findByDepartmentName(String departmentName);

    @Query("SELECT d FROM Department d WHERE d.departmentName like %?1%")
    List<Department> findByDepartmentsByName(String departmentName);

    boolean existsByDepartmentName(String departmentName);

}
