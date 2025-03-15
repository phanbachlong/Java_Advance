package com.vti.demo.form.Department;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.vti.demo.validation.Account.AccountUserNameNotExists;
import com.vti.demo.validation.Department.DepartmentNameNotExists;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

    @NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
    @Length(max = 50, message = "{Department.createDepartment.form.name.Length}")
    @DepartmentNameNotExists
    private String departmentName;

    @NotNull(message = "{Department.createDepartment.form.totalMember.NotNull}")
    @PositiveOrZero(message = "{Department.createDepartment.form.totalMember.PositiveOrZero}")
    private int totalMember;

    @Pattern(regexp = "DEV|TEST|PM|SCRUMMASTER", message = "{Department.createDepartment.form.type.Regex}")
    private String type;

    private List<@Valid Account> accounts;

    @Data
    @NoArgsConstructor
    public static class Account {

        @NotBlank(message = "{Account.createAccount.form.name.NotBlank}")
        @Length(max = 50, message = "{Account.createAccount.form.name.Length}")
        @AccountUserNameNotExists
        private String userName;

        @NotNull(message = "{Account.createAccount.form.firstName.NotNull}")
        @Length(max = 50, message = "{Account.createAccount.form.firstName.Length}")
        private String firstName;

        @NotNull(message = "{Account.createAccount.form.firstName.NotNull}")
        @Length(max = 50, message = "{Account.createAccount.form.firstName.Length}")
        private String lastName;
        private String password = "123456";
    }
}
