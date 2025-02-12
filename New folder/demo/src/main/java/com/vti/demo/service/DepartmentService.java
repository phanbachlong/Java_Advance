package com.vti.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;
import com.vti.demo.repository.IDepartmentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

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
    public void createDeaprtment(CreatingDepartmentForm creatingDepartmentForm) {
        Department department = modelMapper.map(creatingDepartmentForm, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(UpdatingDepartmentForm updatingDepartmentForm) {
        Department department = modelMapper.map(updatingDepartmentForm, Department.class);
        departmentRepository.save(department);
    }
}
