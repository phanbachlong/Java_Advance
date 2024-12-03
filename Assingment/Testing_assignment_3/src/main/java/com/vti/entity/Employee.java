package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Employee`")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AccountID")
    private short accountID;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    @OneToOne
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account account;

    public Employee() {
    }

    public Employee(short workingNumberOfYear, Account account) {
        this.workingNumberOfYear = workingNumberOfYear;
        this.account = account;
    }

    public Employee(short accountID, short workingNumberOfYear, Account account) {
        this.accountID = accountID;
        this.workingNumberOfYear = workingNumberOfYear;
        this.account = account;
    }

    public short getAccountID() {
        return accountID;
    }

    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format("Employee [accountID=%s, workingNumberOfYear=%s, account=%s]", accountID,
                workingNumberOfYear, account.getFullName());
    }

}
