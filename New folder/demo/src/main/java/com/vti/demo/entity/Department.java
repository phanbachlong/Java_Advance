package com.vti.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Department")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int departmentID;

    @Column(name = "department_name", length = 30, nullable = false, unique = true)
    private String departmentName;

    @Column(name = "total_member")
    private int totalNumber;

    @Column(name = "type")
    private String type;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

}
