package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;
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

            Query<Address> query = session.createQuery("FROM Address WHERE deleted = false", Address.class);

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

    @SuppressWarnings("deprecation")
    public void createAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(address);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("deprecation")
    public void updateAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(address);
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
    public void deleteAddress(short addressID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Address address = session.load(Address.class, addressID);

            session.delete(address);

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
    public void softDeletedAddress(short addressID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Address address = session.load(Address.class, addressID);

            DetailDepartment detailDepartment = address.getDetailDepartment();
            if (detailDepartment != null) {
                detailDepartment.setAddress(null);
                session.update(detailDepartment);
            }
            address.setDeleted(true);
            session.update(address);

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
    public void restoreAddress(short addressID) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Address address = session.load(Address.class, addressID);
            address.setDeleted(false);
            session.update(address);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
