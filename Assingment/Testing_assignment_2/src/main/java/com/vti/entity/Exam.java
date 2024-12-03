package com.vti.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import com.vti.repository.ExamRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "`Exam`")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamID")
    private short examID;

    @Column(name = "Code1", length = 10, nullable = false)
    // @GenericGenerator(name = "exam-code-generator", strategy =
    // "com.vti.entity.ExamCodeGenerator")
    private String code1;

    @Column(name = "Duration", nullable = false)
    private short duration = 45;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

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
        return examID;
    }

    public void setExamID(short examID) {
        this.examID = examID;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode1() {
        return code1;
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
        return "Exam [ExamID = " + examID + ", code1 = " + code1 + ", title = " + title
                + ", duration = "
                + duration + ", createDate = " + createDate + "]";
    }

}
