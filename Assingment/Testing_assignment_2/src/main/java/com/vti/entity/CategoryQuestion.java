package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`CategoryQuestion`")
public class CategoryQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short categoryID;

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true)
    private String categoryName;

    @Column(name = "Deleted")
    private boolean deleted = false;

    public CategoryQuestion() {
    }

    public CategoryQuestion(short categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public short getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(short categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "CategoryQuestion [categoryID = " + categoryID + ", categoryName = " + categoryName + "]";
    }

}
