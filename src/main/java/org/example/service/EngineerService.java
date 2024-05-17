package org.example.service;

import org.example.dao.EngineerDao;
import org.example.entity.Engineer;
import org.example.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EngineerService extends SessionUtil implements EngineerDao {
    @Override
    public void add(Engineer engineer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.persist(engineer);

        closeTransactionSession();
    }

    @Override
    public List<Engineer> getAll() throws SQLException {
        openTransactionSession();

        String sql = "Select * from engineers";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Engineer.class);
        List<Engineer> engineers = query.list();
        closeTransactionSession();

        return engineers;
    }

    @Override
    public Engineer getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM engineers WHERE id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Engineer.class);
        query.setParameter("id", id);

        Engineer engineer = (Engineer) query.getSingleResult();

        closeTransactionSession();
        return engineer;
    }

    @Override
    public void update(Engineer engineer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(engineer);

        closeTransactionSession();
    }

    @Override
    public void remove(Engineer engineer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(engineer);

        closeTransactionSession();
    }
}
