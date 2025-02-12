package com.vti.demo.form.Department;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

    @NotBlank(message = "The name mustn't be null value")
    @Length(max = 50, message = "The name's length is max 50 characters")
    private String departmentName;

    @NotNull(message = "The Total Member mustn't be null value")
    @PositiveOrZero(message = "The Total Member must be equal or great than 0 ")
    private int totalMember;

    @Pattern(regexp = "DEV|TEST|PM", message = "The type must be DEV, TEST or PM")
    private String role;

    private List<Account> accounts;

    @Data
    @NoArgsConstructor
    public static class Account {

        private String userName;
        private String firstName;
        private String lastName;
    }
}
