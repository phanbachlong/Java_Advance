package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.ExamQuestion;
import com.vti.utils.HibernateUtils;

public class ExamQuestionRepository {
    private HibernateUtils hibernateUtils;

    public ExamQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<ExamQuestion> getAllExamQuestions() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<ExamQuestion> query = session.createQuery("FROM ExamQuestion", ExamQuestion.class);

            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
