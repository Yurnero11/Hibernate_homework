package org.example;

import org.example.entity.Engineer;
import org.example.entity.Speciality;
import org.example.service.EngineerService;
import org.example.service.SpecialityService;
import org.example.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class HibernateStarter {
    public static void main(String[] args) throws SQLException {
        SpecialityService specialityService = new SpecialityService();
        EngineerService engineerService = new EngineerService();

        Engineer engineer = Engineer.builder()
                .name("Bill")
                .email("bill@gmail.com")
                .build();

        Speciality speciality = Speciality.builder()
                .name("Speciality for Bill")
                .build();

        speciality.getEngineers().add(engineer);

        engineerService.add(engineer);
        specialityService.add(speciality);

        HibernateUtil.shutdown();
    }
}