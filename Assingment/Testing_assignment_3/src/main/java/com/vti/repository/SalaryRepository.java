package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import com.vti.entity.Salary;
import com.vti.entity.Salary.SalaryName;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {
    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Salary> getAllSalaries() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Salary> query = session.createQuery("FROM Salary", Salary.class);

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

    public Salary getSalaryByName(SalaryName salaryName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Salary> query = session.createQuery("FROM Salary WHERE salaryName = :salaryNameParam", Salary.class);
            query.setParameter("salaryNameParam", salaryName);

            return query.uniqueResult();
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
