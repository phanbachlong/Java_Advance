package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {

    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Position> getAllPositions() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Position> query = session.createQuery("FROM Position WHERE deleted = false");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void softDeletePosition(short positionID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Position position = session.load(Position.class, positionID);

            position.setDeleted(true);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void restorePosition(short positionID) {
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Position position = session.load(Position.class, positionID);

            position.setDeleted(false);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
