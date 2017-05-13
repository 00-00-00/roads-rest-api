package com.ground0.rest.util;

import com.ground0.rest.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.inject.Singleton;

/**
 * Created by zer0 on 4/2/17.
 */

@Singleton
public class SessionUtil {

    private static SessionUtil instance = new SessionUtil();
    private SessionFactory sessionFactory;

    public static SessionUtil getInstance() {
        return instance;
    }

    private SessionUtil() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Message.class);
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession() {
        return getInstance().sessionFactory.openSession();
    }
}
