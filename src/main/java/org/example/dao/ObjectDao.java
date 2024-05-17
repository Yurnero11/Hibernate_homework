package org.example.dao;

import org.example.entity.Object;

import java.sql.SQLException;
import java.util.List;

public interface ObjectDao {
    void add(Object object) throws SQLException;

    //Get all engineers
    List<Object> getAll() throws SQLException;

    //Get by id engineer
    Object getById(Long id) throws SQLException;

    //Update Engineer
    void update(Object object) throws SQLException;

    //Remove Engineer
    void remove(Object object) throws SQLException;
}
