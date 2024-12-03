package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Salary`")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SalaryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short salaryID;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName salaryName;

    @OneToMany(mappedBy = "salary")
    private List<Account> accounts;

    public enum SalaryName {
        DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");

        private final String salaryNameValue;

        SalaryName(String salaryNameValue) {
            this.salaryNameValue = salaryNameValue;
        }

        public String getSalaryNameValue() {
            return salaryNameValue;
        }

        public static SalaryName toEnum(String sqlSalaryNameValue) {
            for (SalaryName item : SalaryName.values()) {
                if (item.getSalaryNameValue().equals(sqlSalaryNameValue)) {
                    return item;
                }
            }
            return null;
        }
    }

    public Salary() {
    }

    public Salary(SalaryName salaryName) {
        this.salaryName = salaryName;
    }

    public Salary(short salaryID, SalaryName salaryName) {
        this.salaryID = salaryID;
        this.salaryName = salaryName;
    }

    public short getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(short salaryID) {
        this.salaryID = salaryID;
    }

    public SalaryName getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(SalaryName salaryName) {
        this.salaryName = salaryName;
    }

    @Override
    public String toString() {
        return String.format("Salary [salaryID = %s, salaryName = %s]", salaryID, salaryName);
    }

}
