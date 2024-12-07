package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`DetailDepartment`")
public class DetailDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DepartmentID")
    private short departmentID;

    @MapsId
    @OneToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    public DetailDepartment() {
    }

    public DetailDepartment(Department department, Address address, short emulationPoint) {
        this.department = department;
        this.address = address;
        this.emulationPoint = emulationPoint;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public short getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(short departmentID) {
        this.departmentID = departmentID;
    }

    @Override
    public String toString() {

        String isNullDepartment = department == null ? null : department.getDepartmentName();

        String isNullAddress = address == null ? null : address.getAddressName();
        return String.format(
                "DetailDepartment [departmentID = %s, department = %s, address = %s, emulationPoint = %s]",
                departmentID, isNullDepartment, isNullAddress, emulationPoint);
    }

}
