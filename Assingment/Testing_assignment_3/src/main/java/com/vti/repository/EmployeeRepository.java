package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {
    private HibernateUtils hibernateUtils;

    public EmployeeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Employee> getAllEmployees() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

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
