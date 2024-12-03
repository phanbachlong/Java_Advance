package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;

public class TypeQuestionRepository {

    private HibernateUtils hibernateUtils;

    public TypeQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<TypeQuestion> getAllTypeQuestions() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createTypeQuestion(TypeQuestion typeQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(typeQuestion);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
