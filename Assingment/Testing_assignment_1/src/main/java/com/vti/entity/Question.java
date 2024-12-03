package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short questionID;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate;

    public Question() {
    }

    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Question [questionID = " + questionID + ", content = " + content + ", createDate = " + createDate + "]";
    }

}
