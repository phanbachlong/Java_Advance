package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Account`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @Column(name = "AccountID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short accountID;

    @Column(name = "Email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true)
    private String userName;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;

    @Formula("concat(FirstName, ' ', LastName)")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", referencedColumnName = "PositionID")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "SalaryID", referencedColumnName = "SalaryID")
    private Salary salary;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate = LocalDateTime.now();

    // @OneToOne(mappedBy = "account")
    // private Manager manager;

    // @OneToOne(mappedBy = "account")
    // private Employee employee;

    @OneToMany(mappedBy = "creator")
    private List<Group> groups;

    @OneToMany(mappedBy = "account")
    private List<GroupAccount> groupAccounts;

    @OneToMany(mappedBy = "creator")
    private List<Question> questions;

    @OneToMany(mappedBy = "creator")
    private List<Exam> exams;

    public Account() {
    }

    public Account(String email, String userName, String firstName, String lastName, Department department,
            Position position, Salary salary) {
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public Account(short accountID, String email, String userName, String firstName, String lastName,
            Department department, Position position, Salary salary) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Account [accountID = %s, email = %s, userName = %s, firstName = %s, lastName = %s, fullName = %s, department = %s, position = %s, salary = %s, createDate = %s]",
                accountID, email, userName, firstName, lastName, fullName, department.getDepartmentName(),
                position.getPositionName(), salary.getSalaryName(), createDate);
    }

}
