package com.vti.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "`ExamQuestion`")
@IdClass(ExamQuestionID.class)
public class ExamQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ExamID", nullable = false)
    private short examID;

    @Id
    @Column(name = "QuestionID", nullable = false)
    private short questionID;

    @ManyToOne
    @MapsId("examID")
    @JoinColumn(name = "ExamID", referencedColumnName = "ExamID")
    private Exam exam;

    @ManyToOne
    @MapsId("questionID")
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    private Question question;

    public ExamQuestion() {
    }

    public ExamQuestion(short examID, short questionID) {
        this.examID = examID;
        this.questionID = questionID;
    }

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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return String.format("ExamQuestion [exam = %s, question = %s]", exam, question);
    }

}
