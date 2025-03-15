package com.vti.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @Column(name = "department_name", length = 30, nullable = false, unique = true, updatable = false)
    private String departmentName;

    @Column(name = "total_member")
    private int totalNumber;

    @Column(name = "type", nullable = false)
    @Convert(converter = DepartmentTypeConverter.class)
    private Type type;

    @Column(name = "created_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm-ss")
    private LocalDateTime createdDate = LocalDateTime.now();

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public enum Type {
        DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMater"), PM("PM");

        private String typeName;

        private Type(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

        public static Type toEnum(String sqlType) {
            for (Type item : Type.values()) {
                if (item.getTypeName().equals(sqlType)) {
                    return item;
                }
            }
            return null;
        }
    }

}
