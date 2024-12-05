package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`CategoryQuestion`")
public class CategoryQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CategoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short categoryID;

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "categoryQuestion")
    private List<Question> questions;

    @OneToMany(mappedBy = "categoryQuestion")
    private List<Exam> exams;

    public CategoryQuestion() {
    }

    public CategoryQuestion(String categoryName) {
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return String.format("CategoryQuestion [categoryID = %s, categoryName = %s]", categoryID, categoryName);
    }

}
