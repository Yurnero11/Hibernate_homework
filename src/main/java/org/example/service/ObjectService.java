package org.example.service;

import org.example.dao.ObjectDao;
import org.example.entity.Object;
import org.example.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ObjectService extends SessionUtil implements ObjectDao {
    @Override
    public void add(Object object) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.persist(object);

        closeTransactionSession();
    }

    @Override
    public List<Object> getAll() throws SQLException {
        openTransactionSession();

        String sql = "select * from objects";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Object.class);
        List<Object> objects = query.list();

        closeTransactionSession();
        return objects;
    }

    @Override
    public Object getById(Long id) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        String sql = "Select * from objects where id = :id";
        Query query = session.createNativeQuery(sql).addEntity(Object.class);
        query.setParameter("id", id);

        Object object = (Object) query.getSingleResult();

        closeTransactionSession();

        return object;
    }

    @Override
    public void update(Object object) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(object);

        closeTransactionSession();
    }

    @Override
    public void remove(Object object) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(object);

        closeTransactionSession();
    }
}
