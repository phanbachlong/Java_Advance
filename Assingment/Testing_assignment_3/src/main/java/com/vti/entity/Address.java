package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Address`")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressID;

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String addressName;

    @OneToOne(mappedBy = "address")
    private DetailDepartment detailDepartment;

    private boolean deleted = false;

    public Address() {
    }

    public Address(String addressName) {
        this.addressName = addressName;
    }

    public Address(short addressID, String addressName) {
        this.addressID = addressID;
        this.addressName = addressName;
    }

    public short getAddressID() {
        return addressID;
    }

    public void setAddressID(short addressID) {
        this.addressID = addressID;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public DetailDepartment getDetailDepartment() {
        return detailDepartment;
    }

    public void setDetailDepartment(DetailDepartment detailDepartment) {
        this.detailDepartment = detailDepartment;
    }

    @Override
    public String toString() {
        return String.format("Address [addressID = %s, addressName = %s]", addressID, addressName);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
