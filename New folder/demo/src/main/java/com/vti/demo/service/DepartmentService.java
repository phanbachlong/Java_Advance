package com.vti.demo.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vti.demo.entity.Account;
import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.DepartmentFilterForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;
import com.vti.demo.repository.IAccountRepository;
import com.vti.demo.repository.IDepartmentRepository;
import com.vti.demo.specification.DepartmentSpecification;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search,
            DepartmentFilterForm departmentFilterForm) {
        Specification<Department> where = DepartmentSpecification.buildWhere(search, departmentFilterForm);
        return departmentRepository.findAll(where, pageable);
    }

    @Override
    public Department findDepartmentByID(int departmentID) {
        if (departmentID <= 0) {
            throw new IllegalArgumentException("Department ID must be positive: " + departmentID);
        }
        return departmentRepository.findById(departmentID)
                .orElseThrow(() -> new EntityNotFoundException("Department not exists with ID: " + departmentID));
    }

    @Transactional
    @Override
    public void createDepartment(CreatingDepartmentForm creatingDepartmentForm) {
        Department departmentEntity = modelMapper.map(creatingDepartmentForm, Department.class);
        Department department = departmentRepository.save(departmentEntity);

        List<Account> accounts = departmentEntity.getAccounts();
        for (Account account : accounts) {
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            account.setDepartment(department);
        }

        accountRepository.saveAll(accounts);
    }

    @Override
    public void updateDepartment(UpdatingDepartmentForm updatingDepartmentForm) {
        Department department = modelMapper.map(updatingDepartmentForm, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(int departmentID) {
        departmentRepository.deleteById(departmentID);
    }

    @Override
    public boolean isDepartmentExistsByID(int departmentID) {
        return departmentRepository.existsByDepartmentID(departmentID);
    }

    @Override
    public boolean isDepartmentExistsByName(String departmentName) {
        return departmentRepository.existsByDepartmentName(departmentName);
    }
}
