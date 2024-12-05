package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;

public class AnswerRepository {
    private HibernateUtils hibernateUtils;

    public AnswerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Answer> getAllAnswers() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Answer> query = session.createQuery("FROM Answer", Answer.class);

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
