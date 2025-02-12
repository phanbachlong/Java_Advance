package com.vti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vti.demo.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

    // Department findByDepartmentName(String departmentName);

    @Query("SELECT d FROM Department d WHERE d.departmentName = 'Waitting Room'")
    Department findWaittingRoomDepartment();

    boolean existsByDepartmentName(String departmentName);

}
