package ru.mail.view;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.*;
import com.vaadin.flow.shared.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.mail.listener.IronSwipeEvent;
import ru.mail.model.Car;
import ru.mail.util.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 17.12.2019
 */

@Tag("hello-world")
@JsModule("./src/hello-world.js")
public class LazyPaperCardList extends PolymerTemplate<CarModel>{

    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    private static Integer actualCount;

    @EventHandler
    private void handleSwipe(@ModelItem Car car) {
        System.out.println("Received a message: " + car.getId());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car carToDelete =  session.get(Car.class, car.getId());
        session.delete(carToDelete);
        session.getTransaction().commit();
        actualCount--;
    }

    @EventHandler
    private void loadData() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Car");
        query.setFirstResult(actualCount);
        query.setMaxResults(5);
        List<Car> cars = query.getResultList();
        System.out.println("!!!!! - triggered " + actualCount + " : " + cars.size());
        session.getTransaction().commit();
        getModel().getItems().addAll(cars);
        actualCount = actualCount + cars.size();
    }


   public Registration addIronSwipeListener(ComponentEventListener<IronSwipeEvent> listener) {
       return addListener(IronSwipeEvent.class, listener);
   }

    public LazyPaperCardList() {
        actualCount = 0;
        setId("template");
    }


    public List<Car> getCars () {
        return getModel().getItems();
    }
}
