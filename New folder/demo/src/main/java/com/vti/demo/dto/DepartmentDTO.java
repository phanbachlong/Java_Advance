package com.vti.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {

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
