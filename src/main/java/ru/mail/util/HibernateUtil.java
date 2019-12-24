package ru.mail.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.mail.model.Car;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 24.12.2019
 */

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                ServiceRegistry serviceRegistry
                        = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                configuration.addAnnotatedClass(Car.class);
                return configuration.buildSessionFactory(serviceRegistry);
            }catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException("There is issue in hibernate util");
            }
        }
       return sessionFactory;
    }
}
