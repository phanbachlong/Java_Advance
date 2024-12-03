package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;

public class QuestionRepository {

    private HibernateUtils hibernateUtils;

    public QuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Question> getAllQuestions() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Question> query = session.createQuery("FROM Question");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
