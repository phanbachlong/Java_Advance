package com.vti.demo.form.Account;

import org.hibernate.validator.constraints.Length;

import com.vti.demo.validation.Account.AccountUserNameNotExists;
import com.vti.demo.validation.Department.DepartmentIDNotExists;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

    @NotBlank(message = "{Account.createAccount.form.name.NotBlank}")
    @Length(max = 50, message = "{Account.createAccount.form.name.Length}")
    @AccountUserNameNotExists
    private String userName;

    @NotBlank(message = "{Account.createAccount.form.password.NotBlank}")
    @Length(max = 800, message = "{Account.createAccount.form.password.Length}")
    private String password;

    @NotNull(message = "{Account.createAccount.form.firstName.NotNull}")
    @Length(max = 50, message = "{Account.createAccount.form.firstName.Length}")
    private String firstName;

    @NotNull(message = "{Account.createAccount.form.firstName.NotNull}")
    @Length(max = 50, message = "{Account.createAccount.form.firstName.Length}")
    private String lastName;

    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER", message = "{Account.createAccount.form.role.Regex}")
    private String role = "EMPLOYEE";

    @DepartmentIDNotExists
    private int departmentID;
}
