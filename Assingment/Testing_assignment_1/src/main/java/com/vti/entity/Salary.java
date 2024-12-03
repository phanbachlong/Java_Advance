package com.vti.entity;

import java.io.Serializable;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Salary`")
@Check(constraints = "SalaryName IN (600, 700, 1500, 2000)")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum SalaryName {
        DEV(600), TEST(700), SCRUMMASTER(1500), PM(2000);

        private final int salaryValue;

        SalaryName(int salaryValue) {
            this.salaryValue = salaryValue;
        }

        public int getSalaryValue() {
            return salaryValue;
        }

        public static SalaryName toEnum(Integer sqlSalaryName) {
            for (SalaryName item : SalaryName.values()) {
                if (item.getSalaryValue() == sqlSalaryName) {
                    return item;
                }
            }
            return null;
        }

    }

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short salaryID;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalarySalaryNameConverter.class)
    private SalaryName salaryName;

    @Column(name = "Deleted")
    private boolean deleted;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("Salary [salaryID = %s, salaryName = %s]", salaryID, salaryName);
    }

}
