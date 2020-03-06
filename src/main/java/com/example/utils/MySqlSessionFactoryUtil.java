package com.example.utils;

import com.example.entity.Department;
import com.example.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;


public class MySqlSessionFactoryUtil {
    private static SessionFactory sessionFactory = null;

    private MySqlSessionFactoryUtil() {
    }

    private static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Worker.class)
                .configure();
//create the SessionFactory from configuration
        sessionFactory = configuration
                .buildSessionFactory(
                        new StandardServiceRegistryBuilder()
                                //here you apply the custom dataSource
                                .applySetting(Environment.DATASOURCE, DatasourseHibernate.getDatasourse())
                                .build());


        return sessionFactory;
    }
   /* public static  SessionWrapper openSession() {
        return openSession(true);
    }*/

   @Bean
    public static  Session openSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        final Session session = sessionFactory.openSession();
        /*final SessionWrapper sessionWrapper = new SessionWrapper(session, readOnly);
        return sessionWrapper;*/
        session.beginTransaction();
        return session;
    }


}