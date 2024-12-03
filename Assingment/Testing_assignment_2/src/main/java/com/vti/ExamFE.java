package com.vti;

import java.util.List;

import com.vti.entity.Exam;
import com.vti.repository.ExamRepository;

public class ExamFE {
    private static ExamRepository examRepository = new ExamRepository();

    public static void getAllXExams() {
        List<Exam> exams = examRepository.getAllExams();

        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }

    public static void createExams() {
        Exam exam = new Exam();
        exam.setTitle("dahfa");
        exam.setDuration((short) 60);

        examRepository.createExam(exam);
    }
}
