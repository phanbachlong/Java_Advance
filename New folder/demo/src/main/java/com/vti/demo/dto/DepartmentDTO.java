package com.vti.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.demo.entity.Department.Type;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {

    private int departmentID;
    private String departmentName;
    private int totalMember;
    private Type type;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm-ss")
    private LocalDateTime createdDate;
    private List<AccountDTO> accounts;

    @Data
    @NoArgsConstructor
    static class AccountDTO {
        private String fullName;
        private String role;
    }

}
