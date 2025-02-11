package com.vti.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DepartmentDTO {

    private int departmentID;
    private String departmentName;
    private int totalMember;
    private String type;
    private LocalDateTime createDate;
    private List<AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private String fullName;
        private String role;
    }

}
