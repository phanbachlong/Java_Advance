package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;

public class CategoryQuestionRepository {

    private HibernateUtils hibernateUtils;

    public CategoryQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<CategoryQuestion> getAllCategoryQuestions() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion WHERE deleted = false");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(categoryQuestion);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(categoryQuestion);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteCategoryQuestion(short categoryID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class, categoryID);
            session.delete(categoryQuestion);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void softDeleteCategory(short categoryID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class, categoryID);
            categoryQuestion.setDeleted(true);

            session.update(categoryQuestion);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restoreCategory(short categoryID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            CategoryQuestion categoryQuestion = session.load(CategoryQuestion.class, categoryID);
            categoryQuestion.setDeleted(false);

            session.update(categoryQuestion);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
