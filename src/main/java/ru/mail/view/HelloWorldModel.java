package ru.mail.view;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 17.12.2019
 */

import com.vaadin.flow.templatemodel.TemplateModel;
import ru.mail.model.Car;

import java.util.List;

/**
 * Model for the template.
 */
public interface HelloWorldModel extends TemplateModel {

//     void setItems(List<String> items);
//     List<String> getItems();
     void setCar(Car car);
     List<Car> getItems();


}
