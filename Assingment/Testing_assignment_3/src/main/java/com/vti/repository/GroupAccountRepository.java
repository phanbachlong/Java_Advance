package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.GroupAccount;
import com.vti.utils.HibernateUtils;

public class GroupAccountRepository {

    private HibernateUtils hibernateUtils;

    public GroupAccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<GroupAccount> getAllGroupAccounts() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<GroupAccount> query = session.createQuery("FROM GroupAccount", GroupAccount.class);

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
