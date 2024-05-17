package org.example.dao;

import org.example.entity.Engineer;
import org.example.entity.Speciality;

import java.sql.SQLException;
import java.util.List;

public interface SpecialityDao {
    void add(Speciality speciality) throws SQLException;

    //Get all Specialities
    List<Speciality> getAll() throws SQLException;

    //Get by id Speciality
    Speciality getById(Long id) throws SQLException;

    //Update Speciality
    void update(Speciality speciality) throws SQLException;

    //Remove Speciality
    void remove(Speciality speciality) throws SQLException;
}
