package com.vti.demo.form.Account;

import com.vti.demo.entity.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountFilterFrom {

    private String userName;
    private String firstName;
    private String lastName;
    private Role role;
    private String departmentName;
}
