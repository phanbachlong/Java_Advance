package com.vti.demo.form.Account;

import org.hibernate.validator.constraints.Length;

import com.vti.demo.validation.Account.AccountUserNameNotExists;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {

    @NotBlank(message = "The name mustn't be null value")
    @Length(max = 50, message = "The name's length is max 50 characters")
    @AccountUserNameNotExists
    private String userName;

    @NotBlank(message = "The password mustn't be null value")
    @Length(max = 800, message = "The password's length is max 800 characters")
    private String password;

    @NotNull(message = "The name mustn't be null value")
    @Length(max = 50, message = "The name's length is max 50 characters")
    private String firstName;

    @NotNull(message = "The name mustn't be null value")
    @Length(max = 50, message = "The name's length is max 50 characters")
    private String lastName;

    @Pattern(regexp = "ADMIN|EMPLOYEE|MANAGER", message = "This role must be ADMIN, EMPLOYEE or MANAGER")
    private String role;

    @Positive(message = "The department id must be great than 0")
    private int departmentID;
}
