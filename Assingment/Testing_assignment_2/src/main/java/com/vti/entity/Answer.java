package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Answer`")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AnswerID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short answerID;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @Column(name = "isCorrect", columnDefinition = "BIT")
    private boolean isCorrect = true;

    public Answer() {
    }

    public short getAnswerID() {
        return answerID;
    }

    public void setAnswerID(short answerID) {
        this.answerID = answerID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "Answer [answerID = " + answerID + ", content = " + content + ", isCorrect = " + isCorrect + "]";
    }
}
