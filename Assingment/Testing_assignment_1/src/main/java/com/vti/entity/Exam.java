package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Exam`")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short ExamID;

    @Column(name = "Code1", length = 10, nullable = false)
    private String code1;

    @Column(name = "Code2", length = 10, nullable = false)
    private String code2;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @Column(name = "Duration", nullable = false)
    private short duration = 45;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createDate = LocalDateTime.now();

    public Exam() {
    }

    public Exam(String title, short duration) {
        this.title = title;
        this.duration = duration;
    }

    public short getExamID() {
        return ExamID;
    }

    public void setExamID(short examID) {
        ExamID = examID;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam [ExamID = " + ExamID + ", code1 = " + code1 + ", code2 = " + code2 + ", title = " + title
                + ", duration = "
                + duration + ", createDate = " + createDate + "]";
    }

}
