package com.vti.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Department;
import com.vti.demo.repository.IDepartmentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department findDepartmentByID(int departmentID) {
        if (departmentID <= 0) {
            throw new IllegalArgumentException("Department ID must be positive: " + departmentID);
        }
        return departmentRepository.findById(departmentID)
                .orElseThrow(() -> new EntityNotFoundException("Department not exists with ID: " + departmentID));
    }

    @Override
    public Department insertDepartment(Department department) {
        if (departmentRepository.existsByDepartmentName(department.getDepartmentName())) {
            throw new DataIntegrityViolationException("Department name already exists: " +
                    department.getDepartmentName());
        }
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentByID(int departmentID) {
        if (!departmentRepository.existsById(departmentID)) {
            throw new EntityNotFoundException("Department not exists with ID: " + departmentID);
        }
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public Department updateDepartment(int departmentID, Department upDepartment) {
        Department existsDepartment = departmentRepository.findById(departmentID)
                .orElseThrow(() -> new EntityNotFoundException("Department not exists with ID: " + departmentID));

        if (departmentRepository.existsByDepartmentName(upDepartment.getDepartmentName())) {
            throw new IllegalArgumentException("Department name already exists: " +
                    upDepartment.getDepartmentName());
        }

        existsDepartment.setDepartmentName(upDepartment.getDepartmentName());
        existsDepartment.setTotalNumber(upDepartment.getTotalNumber());
        existsDepartment.setType(upDepartment.getType());
        existsDepartment.setCreateDate(upDepartment.getCreateDate());

        return departmentRepository.save(existsDepartment);
    }
}
