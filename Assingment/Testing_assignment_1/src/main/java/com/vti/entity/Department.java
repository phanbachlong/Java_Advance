package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Department`")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short departmentID;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String departmentName;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(short departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("Department [departmentID = %s, departmentName = %s]", departmentID, departmentName);
    }

}
