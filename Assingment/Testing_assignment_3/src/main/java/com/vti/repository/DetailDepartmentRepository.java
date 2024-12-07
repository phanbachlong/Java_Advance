package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DetailDepartmentRepository {

    private HibernateUtils hibernateUtils;

    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<DetailDepartment> getAllDetailDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment", DetailDepartment.class);

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void createDetailDepartment(DetailDepartment detailDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.save(detailDepartment);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
