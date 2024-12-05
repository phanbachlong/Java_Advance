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
@Table(name = "`Exam`")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ExamID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short examID;

    @Column(name = "`Code`", nullable = false, updatable = false)
    private String code;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private CategoryQuestion categoryQuestion;

    @Column(name = "Duration", nullable = false)
    private short duration = 45;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID")
    private Account creator;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate = LocalDateTime.now();

    @OneToMany(mappedBy = "exam")
    private List<ExamQuestion> examQuestions;

    public Exam() {
    }

    public Exam(String code, String title, CategoryQuestion categoryQuestion, short duration, Account creator,
            LocalDateTime createDate) {
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }

    public Exam(short examID, String code, String title, CategoryQuestion categoryQuestion, short duration,
            Account creator, LocalDateTime createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryQuestion = categoryQuestion;
        this.duration = duration;
        this.creator = creator;
        this.createDate = createDate;
    }

    public short getExamID() {
        return examID;
    }

    public void setExamID(short examID) {
        this.examID = examID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Exam [examID = %s, code = %s, title = %s, categoryQuestion = %s, duration = %s, creator = %s, createDate = %s]",
                examID, code, title, categoryQuestion.getCategoryName(), duration, creator.getFullName(), createDate);
    }

}
