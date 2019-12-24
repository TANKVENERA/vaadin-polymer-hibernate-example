package ru.mail.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.mail.model.Car;

import javax.persistence.Query;
import java.util.List;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 24.12.2019
 */

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("select count(c) from Car c");
        Long number =  (Long)query.getSingleResult();

        session.getTransaction().commit();
        System.out.println(number);

    }
}
