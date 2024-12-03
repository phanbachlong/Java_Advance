package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {
    private HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Account> getAllAccounts() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Account> query = session.createQuery("FROM Account WHERE deleted = false");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createAccount(Account account) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(account);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteAccount(short accountID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Account account = session.load(Account.class, accountID);

            session.delete(account);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateAccount(Account account) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(account);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void softDeleteAccount(short accountID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Account account = session.load(Account.class, accountID);

            account.setDeleted(true);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restoreAccount(short accountID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Account account = session.load(Account.class, accountID);

            account.setDeleted(false);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
