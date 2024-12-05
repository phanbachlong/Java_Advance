package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;

public class TypeQuestionRepository {
    private HibernateUtils hibernateUtils;

    public TypeQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<TypeQuestion> getAllTypeQuestions() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion", TypeQuestion.class);

            return query.list();
        } catch (HqlInterpretationException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
