package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {

    private HibernateUtils hibernateUtils;

    public ManagerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Manager> getAllManagers() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Manager> query = session.createQuery("FROM Manager", Manager.class);

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

    public void createManager(Manager manager) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.persist(manager);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
