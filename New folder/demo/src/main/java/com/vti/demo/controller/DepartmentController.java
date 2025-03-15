package com.vti.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.demo.dto.DepartmentDTO;
import com.vti.demo.entity.Account;
import com.vti.demo.entity.Department;
import com.vti.demo.form.Department.CreatingDepartmentForm;
import com.vti.demo.form.Department.DepartmentFilterForm;
import com.vti.demo.form.Department.UpdatingDepartmentForm;
import com.vti.demo.repository.IAccountRepository;
import com.vti.demo.service.IDepartmentService;
import com.vti.demo.validation.Department.DepartmentIDNotExists;

import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "api/v1/departments")
@Validated
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable,
            @RequestParam(value = "search", required = false) String search,
            DepartmentFilterForm departmentFilterForm) {
        Page<Department> departmentPages = departmentService.getAllDepartments(pageable, search, departmentFilterForm);

        Page<DepartmentDTO> departmentDTOPages = departmentPages
                .map(department -> modelMapper.map(department, DepartmentDTO.class));

        departmentDTOPages.getContent().forEach(dto -> dto.add(linkTo(methodOn(DepartmentController.class)
                .getDepartmentByID(dto.getDepartmentID()))
                .withSelfRel()));
        return departmentDTOPages;
        // Filter: filter theo min created date, max created date, hoặc type(missing)
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentByID(@DepartmentIDNotExists @PathVariable(value = "id") int departmentID) {
        Department department = departmentService.findDepartmentByID(departmentID);
        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }

    @PostMapping()
    public void createDepartment(@RequestBody @Valid CreatingDepartmentForm creatingDepartmentForm) {
        departmentService.createDepartment(creatingDepartmentForm);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@DepartmentIDNotExists @PathVariable(value = "id") int departmentID,
            @RequestBody @Valid UpdatingDepartmentForm updatingDepartmentForm) {

        updatingDepartmentForm.setDepartmentID(departmentID);
        departmentService.updateDepartment(updatingDepartmentForm);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable(value = "id") int departmentID) {
        departmentService.deleteDepartment(departmentID);
    }

}
