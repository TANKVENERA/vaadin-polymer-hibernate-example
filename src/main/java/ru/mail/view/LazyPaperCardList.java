package ru.mail.view;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.mail.model.Car;
import ru.mail.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 17.12.2019
 */

@Tag("hello-world")
@NpmPackage(value = "@polymer/iron-swipeable-container", version = "3.0.1")
@NpmPackage(value = "@polymer/paper-card", version = "3.0.1")
@NpmPackage(value = "@polymer/iron-scroll-threshold", version = "3.0.1")
@JsModule("./src/hello-world.js")
public class LazyPaperCardList extends PolymerTemplate<CarModel> {

    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public LazyPaperCardList() {
        setId("template");
    }

    @ClientCallable
    public void loadMoreData (Integer size) {
        if (Long.valueOf(size) !=  getCarAmount()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("From Car");
            query.setFirstResult(size);
            query.setMaxResults(5);
            List<Car> cars = query.getResultList();
            session.getTransaction().commit();
            getModel().getItems().addAll(cars);
        }
    }

    @ClientCallable
    public void deleteItem (Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car carToDelete =  session.get(Car.class, id);
        session.delete(carToDelete);
        session.getTransaction().commit();
    }

    public Long getCarAmount() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("select count(c) from Car c");
        Long number =  (Long) query.getSingleResult();
        session.getTransaction().commit();
        return  number;
    }

    public List<Car> getCars () {
        return getModel().getItems();
    }
}
