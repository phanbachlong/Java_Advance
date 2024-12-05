package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GroupID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short groupID;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID")
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate = LocalDateTime.now();

    @OneToMany(mappedBy = "group")
    private List<GroupAccount> groupAccounts;

    public Group() {
    }

    public Group(String groupName, Account account, LocalDateTime createDate) {
        this.groupName = groupName;
        this.creator = account;
        this.createDate = createDate;
    }

    public Group(short groupID, String groupName, Account account, LocalDateTime createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creator = account;
        this.createDate = createDate;
    }

    public short getGroupID() {
        return groupID;
    }

    public void setGroupID(short groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setAccount(Account account) {
        this.creator = account;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return String.format("Group [groupID = %s, groupName = %s, account = %s, createDate = %s]", groupID, groupName,
                creator.getFullName(), createDate);
    }

}
