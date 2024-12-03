package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;

public class GroupRepository {

    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Group> getAllGroups() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("FROM Group", Group.class);

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
