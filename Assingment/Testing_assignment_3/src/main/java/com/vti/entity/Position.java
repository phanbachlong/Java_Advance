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
@Table(name = "`Position`")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum PositionName {
        DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

        private final String positionNameItem;

        PositionName(String positionNameItem) {
            this.positionNameItem = positionNameItem;
        }

        public String getPositionNameItem() {
            return positionNameItem;
        }

        public static PositionName toEnum(String sqlPositionName) {
            for (PositionName item : PositionName.values()) {
                if (item.getPositionNameItem().equals(sqlPositionName)) {
                    return item;
                }
            }
            return null;
        }
    }

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short positionID;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)
    private PositionName positionName;

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return String.format("Position [positionID = %s, positionName = %s]", positionID, positionName);
    }

}
