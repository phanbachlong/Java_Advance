package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {

    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Salary> getAllSalaries() {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();

            // create HQL query
            Query<Salary> query = session.createQuery("FROM Salary WHERE deleted = false");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void softDeleteSalary(short salaryID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Salary salary = session.load(Salary.class, salaryID);

            salary.setDeleted(true);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restorePosition(short salaryID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Salary salary = session.load(Salary.class, salaryID);

            salary.setDeleted(false);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
