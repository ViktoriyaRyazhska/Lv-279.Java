/*
* HibernateUtil
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.softserve.data.entity.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Academy.class)
                    .addAnnotatedClass(AcademyStage.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(Direction.class)
                    .addAnnotatedClass(ItaAcademy.class)
                    .addAnnotatedClass(ItaAcademyStatus.class)
                    .addAnnotatedClass(ItaTimeSlots.class)
                    .addAnnotatedClass(Technology.class)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
