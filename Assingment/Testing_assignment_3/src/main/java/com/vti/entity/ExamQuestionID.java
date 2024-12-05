package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ExamQuestionID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    private short examID;

    @Column(name = "QuestionID")
    private short questionID;

    public short getExamID() {
        return examID;
    }

    public void setExamID(short examID) {
        this.examID = examID;
    }

    public short getQuestionID() {
        return questionID;
    }

    public void setQuestionID(short questionID) {
        this.questionID = questionID;
    }

}
