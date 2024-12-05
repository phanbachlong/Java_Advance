package com.vti.entity;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`Answer`")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Answers")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short answerID;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    private Question question;

    @Column(name = "isCorrect", columnDefinition = "BIT")
    private boolean isCorrect;

    public Answer() {
    }

    public Answer(String content, Question question, boolean isCorrect) {
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public Answer(short answerID, String content, Question question, boolean isCorrect) {
        this.answerID = answerID;
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return String.format("Answer [answerID = %s, content = %s, question = %s, isCorrect = %s]", answerID, content,
                question, isCorrect);
    }

}
