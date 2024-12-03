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

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Group> getAllGroups() {
        Session session = null;

        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group WHERE deleted = false");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createGroup(Group group) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(group);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Group getGroupByID(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // get by id
            Group group = session.get(Group.class, id);
            return group;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public Group getGroupByName(String name) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group WHERE groupName = :nameParam and deleted = false");

            // set param
            query.setParameter("nameParam", name);

            // get rs
            Group group = query.uniqueResult();

            return group;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateGroup(Group group) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(group);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteGroup(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get group
            Group group = (Group) session.load(Group.class, id);

            // delete
            session.delete(group);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupExistsByID(short id) {
        Group group = getGroupByID(id);

        if (group == null) {
            return false;
        }
        return true;
    }

    public boolean isGroupExistsByName(String name) {
        Group group = getGroupByName(name);

        if (group == null) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("deprecation")
    public void softDeleteGroup(short groupID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Group group = session.load(Group.class, groupID);

            group.setDeleted(true);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restoreGroup(short groupID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Group group = session.load(Group.class, groupID);

            group.setDeleted(false);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
