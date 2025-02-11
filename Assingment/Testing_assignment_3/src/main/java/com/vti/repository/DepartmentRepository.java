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
            Query<Department> query = session.createQuery("FROM Department WHERE deleted = false", Department.class);

            return query.list();

        } finally {
            if (session != null && session.isOpen()) {
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
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Department getDepartmentWaitingRoom() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department WHERE departmentName = 'Waiting Room'",
                    Department.class);

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

    public boolean getDepartmentForUpdate(Department department) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Query<Long> query = session.createQuery(
                    "SELECT COUNT(1) FROM Department WHERE departmentID <> :departmentIDParam AND departmentName = :departmentNameParam",
                    Long.class);

            query.setParameter("departmentIDParam", department.getDepartmentID());
            query.setParameter("departmentNameParam", department.getDepartmentName());

            Long count = query.uniqueResult();

            return count > 0;
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDepartment(Department department) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.merge(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createDepartment(Department department) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.persist(department);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void deleteDepartment(short departmentID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Department department = session.load(Department.class, departmentID);

            session.delete(department);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Department> getLisDepartments(int page, int size) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery(
                    "SELECT d.departmentID, d.departmentName FROM Department d  ORDER BY d.departmentName",
                    Department.class);
            int offset = (page - 1) * size;
            int limit = size;

            query.setFirstResult(offset);
            query.setMaxResults(limit);

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
