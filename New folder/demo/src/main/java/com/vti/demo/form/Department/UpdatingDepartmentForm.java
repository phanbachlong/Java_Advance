package com.vti.demo.form.Department;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.vti.demo.entity.Department.Type;
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
public class UpdatingDepartmentForm {
    @NotNull(message = "The Department's is mustn't be null")
    private int departmentID;

    // @NotBlank(message = "The name mustn't be null value")
    // @Length(max = 50, message = "The name's length is max 50 characters")
    // @DepartmentNameNotExists
    // private String departmentName;

    // @NotNull(message = "The Total Member mustn't be null value")
    // @PositiveOrZero(message = "The Total Member must be equal or great than 0 ")
    // private int totalMember;

    @Pattern(regexp = "DEV|TEST|PM|SCRUMMASTER", message = "The type must be DEV, TEST, PM or SCRUMMASTER")
    private String type;

    // private List<@Valid Account> accounts;

    // @Data
    // @NoArgsConstructor
    // public static class Account {

    // @NotBlank(message = "The name mustn't be null value")
    // @Length(max = 50, message = "The name's length is max 50 characters")
    // @AccountUserNameNotExists
    // private String userName;
    // private String firstName;
    // private String lastName;
    // }
}