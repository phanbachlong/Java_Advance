package com.vti.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.DepartmentDTO;
import com.vti.demo.entity.Department;
import com.vti.demo.service.IDepartmentService;

import jakarta.persistence.EntityNotFoundException;

import java.util.Collections;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    // public List<DepartmentDTO> getAllDepartments() {
    // List<Department> departments = departmentService.getAllDepartments();

    // List<DepartmentDTO> departmentDTOs = departments.stream()
    // .map(department -> modelMapper.map(department,
    // DepartmentDTO.class)).collect(Collectors.toList());

    // return departmentDTOs;
    // }
    public ResponseEntity<?> getAllDepartments(Pageable pageable) {
        Page<Department> departmentPages = departmentService.getAllDepartments(pageable);

        Page<DepartmentDTO> departmentDTOPages = departmentPages
                .map(departmentPage -> modelMapper.map(departmentPage, DepartmentDTO.class));

        return ResponseEntity.ok().body(departmentDTOPages);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") int departmentID) {
        Department department = departmentService.findDepartmentByID(departmentID);
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return ResponseEntity.ok(departmentDTO);

    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody Department department) {
        Department saveDepartment = departmentService.insertDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") int departmentID) {
        departmentService.deleteDepartmentByID(departmentID);
        return ResponseEntity.ok(Collections.singletonMap("message", "Department deleted successfully!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") int departmentID,
            @RequestBody Department department) {
        try {
            Department upDepartment = departmentService.updateDepartment(departmentID, department);
            return ResponseEntity.ok(upDepartment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @ExceptionHandler({ EntityNotFoundException.class, IllegalArgumentException.class,
            DataIntegrityViolationException.class })
    public ResponseEntity<String> handleEntityNotFoundException(Exception e) {
        HttpStatus httpStatus = null;
        if (e instanceof EntityNotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else if (e instanceof IllegalArgumentException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (e instanceof DataIntegrityViolationException) {
            httpStatus = HttpStatus.CONFLICT;
        }
        return ResponseEntity.status(httpStatus).body(e.getMessage());
    }
}
