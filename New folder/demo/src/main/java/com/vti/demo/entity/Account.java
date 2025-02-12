package com.vti.demo.entity;

import java.io.Serializable;

import org.hibernate.annotations.Formula;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int accountID;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String userName;

    @Column(name = "password", length = 800, nullable = false, unique = true)
    private String password;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Formula("CONCAT(first_name,' ',last_name)")
    private String fullName;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYEE;

    @ManyToOne
    @JoinColumn(name = "department_id", columnDefinition = "id")
    private Department department;
}
