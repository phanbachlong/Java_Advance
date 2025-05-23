package com.vti.demo.form.Account;

import com.vti.demo.validation.Department.DepartmentIDNotExists;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingAccountForm {
    @NotNull(message = "The Account's is mustn't be null")
    private int accountID;

    @NotBlank(message = "This role must be ADMIN, EMPLOYEE or MANAGER")
    @NotNull(message = "This role must be ADMIN, EMPLOYEE or MANAGER")
    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER", message = "This role must be ADMIN, EMPLOYEE or MANAGER")
    private String role;

    private String password;

    @DepartmentIDNotExists
    private int departmentID;
}
