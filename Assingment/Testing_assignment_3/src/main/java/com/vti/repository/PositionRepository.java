package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.hql.HqlInterpretationException;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {

    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Position> getAllPositions() {
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Position> query = session.createQuery("FROM Position", Position.class);

            return query.list();
        } catch (HqlInterpretationException e) {
            e.getMessage();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Position getPositionByName(Position.PositionName positionName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Position> query = session.createQuery("FROM Position WHERE positionName = :positionNameParam",
                    Position.class);

            query.setParameter("positionNameParam", positionName);

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
