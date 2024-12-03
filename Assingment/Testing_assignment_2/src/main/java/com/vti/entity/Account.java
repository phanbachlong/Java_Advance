package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Account`")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short accountID;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;

    @Formula("concat(FirstName, ' ', LastName)")
    private String fullName;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @Column(name = "Deleted")
    private boolean deleted = false;

    @PreUpdate
    protected void updateDateUpdate() {
        updateDate = LocalDateTime.now();
    }

    public Account() {
    }

    public Account(String email, String userName, String firstName, String lastName) {
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(short accountID, String email, String userName, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createDate = LocalDateTime.now();
    }

    public short getAccountID() {
        return accountID;
    }

    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "Account [accountID = " + accountID + ", email = " + email + ", userName = " + userName
                + ", firstName = " + fullName + ", createDate = " + createDate + "]";
    }

}
