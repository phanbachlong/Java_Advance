package com.vti.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vti.demo.config.CustomLocalDateTimeDeserializer;

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

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "create_date")
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime createDate = LocalDateTime.now();

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

}
