package com.vti.demo.validation.Department;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.demo.service.IDepartmentService;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists, String> {

    @Autowired
    private IDepartmentService departmentService;

    @Override
    public boolean isValid(String departmentName, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(departmentName)) {
            return true;
        }
        return !departmentService.isDepartmentExistsByName(departmentName);
    }

}
