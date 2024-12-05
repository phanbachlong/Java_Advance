package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;

public class CategoryRepository {

    private HibernateUtils hibernateUtils;

    public CategoryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<CategoryQuestion> getAllCategories() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion", CategoryQuestion.class);

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
