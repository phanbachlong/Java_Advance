package com.vti.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountDTO {

    private int accountID;
    private String fullName;
    private String userName;
    private String role;
    private DepartmentDTO department;

    @NoArgsConstructor
    @Data
    static class DepartmentDTO {
        private String departmentName;
    }
}
