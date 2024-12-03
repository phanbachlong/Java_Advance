package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short groupID;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @Column(name = "Deleted")
    private boolean deleted;

    @PreUpdate
    protected void updateDateUpdate() {
        this.updateDate = LocalDateTime.now();
    }

    public Group() {
    }

    public Group(String name, LocalDateTime createDate) {
        this.groupName = name;
        this.createDate = createDate;
    }

    public Group(short groupID, String groupName, LocalDateTime createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.createDate = createDate;
    }

    public short getId() {
        return groupID;
    }

    public void setId(short id) {
        this.groupID = id;
    }

    public String getName() {
        return groupName;
    }

    public void setName(String name) {
        this.groupName = name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return String.format("Group [groupID = %s, groupName = %s, createDate = %s]", groupID, groupName, createDate);
    }

}
