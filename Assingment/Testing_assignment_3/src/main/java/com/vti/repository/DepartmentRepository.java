package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Department> getAllDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Department> query = session.createQuery("FROM Department", Department.class);

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Department getDepartmentByID(short departmentID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department WHERE departmentID = :departmentIDParam",
                    Department.class);

            query.setParameter("departmentIDParam", departmentID);

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
