package com.vti.demo.form.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {
    private String departmentName;
    private int totalMember;
    private String role;

}
