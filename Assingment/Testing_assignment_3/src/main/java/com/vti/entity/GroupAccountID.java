package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GroupAccountID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID")
    private short groupID;

    @Column(name = "AccountID")
    private short accountID;

    public GroupAccountID() {
    }

    public short getGroupID() {
        return groupID;
    }

    public void setGroupID(short groupID) {
        this.groupID = groupID;
    }

    public short getAccountID() {
        return accountID;
    }

    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }
}
