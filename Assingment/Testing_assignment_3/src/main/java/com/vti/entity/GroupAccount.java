package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`GroupAccount`")
@IdClass(GroupAccountID.class)
public class GroupAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GroupID", nullable = false)
    private short groupID;

    @Id
    @Column(name = "AccountID", nullable = false)
    private short accountID;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime joinDate = LocalDateTime.now();

    @ManyToOne
    @MapsId("groupID")
    @JoinColumn(name = "GroupID")
    private Group group;

    @ManyToOne
    @MapsId("accountID")
    @JoinColumn(name = "AccountID")
    private Account account;

    public GroupAccount() {
    }

    public GroupAccount(short groupID, short accountID, LocalDateTime joinDate) {
        this.groupID = groupID;
        this.accountID = accountID;
        this.joinDate = joinDate;
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

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return String.format(
                "GroupAccount [groupID = %s, accountID = %s, joinDate = %s, group = %s, account = %s, creator = %s]",
                groupID, accountID, joinDate, group.getGroupName(), account.getFullName(),
                group.getCreator().getFullName());
    }
}
