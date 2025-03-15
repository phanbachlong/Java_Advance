package com.vti.demo.validation.Department;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.demo.service.IDepartmentService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentIDNotExistsValidator implements ConstraintValidator<DepartmentIDNotExists, Integer> {
    @Autowired
    private IDepartmentService departmentService;

    @Override
    public boolean isValid(Integer departmentID, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(departmentID.toString())) {
            return true;
        }
        return departmentService.isDepartmentExistsByID(departmentID);
    }

}