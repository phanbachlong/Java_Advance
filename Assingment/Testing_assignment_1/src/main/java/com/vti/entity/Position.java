package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Position`")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short positionID;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public enum PositionName {
        DEV, TEST, SCRUMMASTER, PM
    }

    public Position() {
    }

    public Position(PositionName positionName) {
        this.positionName = positionName;
    }

    public Position(short positionID, PositionName positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public short getPositionID() {
        return positionID;
    }

    public void setPositionID(short positionID) {
        this.positionID = positionID;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("Position [positionID = %s, positionName = %s]", positionID, positionName);
    }

}
