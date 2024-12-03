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

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Answer> getAlAnswers() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Answer> query = session.createQuery("FROM Answer");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createAnswer(Answer answer) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(answer);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateAnswer(Answer answer) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(answer);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteAnswer(short answerID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Answer answer = session.load(Answer.class, answerID);
            session.delete(answer);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
