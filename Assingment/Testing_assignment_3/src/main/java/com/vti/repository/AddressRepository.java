package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;

public class AddressRepository {
    private HibernateUtils hibernateUtils;

    public AddressRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Address> getAllAddresses() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Address> query = session.createQuery("FROM Address", Address.class);

            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isConnected()) {
                session.close();
            }
        }
    }

    public Address getAddressByID(short addressID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Address> query = session.createQuery("FROM Address WHERE addressID = :addressIDParam", Address.class);

            query.setParameter("addressIDParam", addressID);

            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null && session.isConnected()) {
                session.close();
            }
        }
    }

    public void createAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.persist(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isConnected()) {
                session.close();
            }
        }
    }

    public void updateAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.merge(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isConnected()) {
                session.close();
            }
        }
    }
}
