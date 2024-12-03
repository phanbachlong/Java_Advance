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

    @SuppressWarnings({ "deprecation", "unused" })
    public void createExam(Exam exam) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            // session.beginTransaction();

            int count = getCountByDuration(exam.getDuration());
            String code = generateCode(exam.getDuration(), count);

            exam.setCode1(code);

            session.save(exam);
            // session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public int getCountByDuration(short duration) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Long> query = null;

            if (duration > 0 && duration < 90) {
                query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE duration > 0 AND duration < 90 ");
            } else if (duration >= 90 && duration < 180) {
                query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE duration >= 90 AND duration < 180 ");
            } else {
                query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE duration >= 180 ");
            }
            return query.uniqueResult().intValue();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public String generateCode(short duration, int count) {
        if (duration > 0 && duration < 90) {
            return "S-" + (count + 1);
        } else if (duration >= 90 && duration < 180) {
            return "M-" + (count + 1);
        } else {
            return "L-" + (count + 1);
        }
    }
}
