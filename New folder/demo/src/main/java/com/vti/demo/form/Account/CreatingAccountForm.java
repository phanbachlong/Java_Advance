package com.vti.demo.form.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingAccountForm {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int departmentID;
}
