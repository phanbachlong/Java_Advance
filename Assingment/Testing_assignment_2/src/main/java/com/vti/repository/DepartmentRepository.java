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

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Department> getAllDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department WHERE deleted = false");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createDepartment(Department department) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(department);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateDepartment(Department department) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(department);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void softDeleteDepartment(short departmentID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = session.load(Department.class, departmentID);
            department.setDeleted(true);
            session.update(department);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restoreDepartment(short departmentID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = session.load(Department.class, departmentID);
            department.setDeleted(false);
            session.update(department);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
