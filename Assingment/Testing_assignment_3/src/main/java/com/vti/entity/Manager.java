package com.vti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Manager`")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account {
    private static final long serialVersionUID = 1l;

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    // @OneToOne
    // @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    // private Account account;

    public Manager() {
    }

    public Manager(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public Manager(String email, String userName, String firstName, String lastName, Department department,
            Position position, Salary salary, short workingNumberOfYear) {
        super(email, userName, firstName, lastName, department, position, salary);
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        return String.format("Manager [workingNumberOfYear=%s]", workingNumberOfYear);
    }

}
