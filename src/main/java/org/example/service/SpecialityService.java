package org.example.service;

import org.example.dao.SpecialityDao;
import org.example.entity.Object;
import org.example.entity.Speciality;
import org.example.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class SpecialityService extends SessionUtil implements SpecialityDao {
    @Override
    public void add(Speciality speciality) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.persist(speciality);

        closeTransactionSession();
    }

    @Override
    public List<Speciality> getAll() throws SQLException {
        openTransactionSession();

        String sql = "select * from specialities";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Speciality.class);
        List<Speciality> specialities = query.list();

        closeTransactionSession();
        return specialities;
    }

    @Override
    public Speciality getById(Long id) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        String sql = "Select * from specialities where id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Speciality.class);
        query.setParameter("id", id);

        Speciality speciality = (Speciality) query.getSingleResult();

        closeTransactionSession();

        return speciality;
    }

    @Override
    public void update(Speciality speciality) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(speciality);

        closeTransactionSession();
    }

    @Override
    public void remove(Speciality speciality) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(speciality);

        closeTransactionSession();
    }
}
