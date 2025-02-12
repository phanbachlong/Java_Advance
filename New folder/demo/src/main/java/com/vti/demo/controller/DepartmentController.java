package com.vti.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.DepartmentDTO;
import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;
import com.vti.demo.service.IDepartmentService;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments(Pageable pageable) {
        Page<Department> departmentPages = departmentService.getAllDepartments(pageable);

        Page<DepartmentDTO> departmentDTOPages = departmentPages
                .map(department -> modelMapper.map(department, DepartmentDTO.class));

        departmentDTOPages.getContent().forEach(dto -> dto.add(linkTo(methodOn(DepartmentController.class)
                .getDepartmentByID(dto.getDepartmentID()))
                .withSelfRel()));
        return ResponseEntity.ok().body(departmentDTOPages);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") int departmentID) {
        Department department = departmentService.findDepartmentByID(departmentID);
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return ResponseEntity.ok(departmentDTO);

    }

    @PostMapping()
    public void createDepartment(@RequestBody @Valid CreatingDepartmentForm creatingDepartmentForm) {
        departmentService.createDepartment(creatingDepartmentForm);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable(value = "id") int departmentID,
            @RequestBody UpdatingDepartmentForm updatingDepartmentForm) {
        updatingDepartmentForm.setDepartmentID(departmentID);
        departmentService.updateDepartment(updatingDepartmentForm);
    }
}
