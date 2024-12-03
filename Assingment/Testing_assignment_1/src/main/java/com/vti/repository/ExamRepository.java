package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {
    private HibernateUtils hibernateUtils;

    public ExamRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Exam> getAllExams() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Exam> query = session.createQuery("FROM Exam");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked", "unused" })
    public void createExam(Exam exam) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            int count = 0;

            String code1 = null;

            if (exam.getDuration() >= 180) {
                Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE duration >= 180");

                count = query.uniqueResult().intValue();

                code1 = "L" + "-" + (count + 1);
            } else if (exam.getDuration() >= 90 && exam.getDuration() < 180) {
                Query<Long> query = session
                        .createQuery("SELECT COUNT(1) FROM Exam WHERE duration < 180 and duration >= 90");

                count = query.uniqueResult().intValue();

                code1 = "M" + "-" + (count + 1);
            } else {
                Query<Long> query = session
                        .createQuery("SELECT COUNT(1) FROM Exam WHERE duration < 90");
                count = query.uniqueResult().intValue();

                code1 = "S" + "-" + (count + 1);
            }

            exam.setCode1(code1);
            exam.setCode2(code1);
            session.save(exam);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
