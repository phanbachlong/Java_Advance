package com.vti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Employee`")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account {

    private static final long serialVersionUID = 1L;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    // @OneToOne
    // @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    // private Account account;

    public Employee() {
    }

    public Employee(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public Employee(String email, String userName, String firstName, String lastName, Department department,
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
        return String.format("Employee [name = %s, workingNumberOfYear = %s]", super.getFullName(),
                workingNumberOfYear);
    }

}
