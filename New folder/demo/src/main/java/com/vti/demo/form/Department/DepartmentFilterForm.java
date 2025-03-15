package com.vti.demo.form.Department;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {

    private LocalDate minDate;
    private LocalDate maxDate;
}