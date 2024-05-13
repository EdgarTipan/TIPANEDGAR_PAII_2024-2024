package ec.edu.uce.models;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Edgar Tipan
 */

public class SessionFactorySingleton {

    private static SessionFactory sessionFactory;

    private SessionFactorySingleton() {}

    public static synchronized SessionFactory getSessionFactory(Configuration config) {
        if (sessionFactory == null) {
            sessionFactory = config.buildSessionFactory();
        }
        return sessionFactory;
    }
}
