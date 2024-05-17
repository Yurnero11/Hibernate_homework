package org.example.dao;

import org.example.entity.Engineer;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public interface EngineerDao {
    //Add
    void add(Engineer engineer) throws SQLException;

    //Get all engineers
    List<Engineer> getAll() throws SQLException;

    //Get by id engineer
    Engineer getById(Long id) throws SQLException;

    //Update Engineer
    void update(Engineer engineer) throws SQLException;

    //Remove Engineer
    void remove(Engineer engineer) throws SQLException;
}
