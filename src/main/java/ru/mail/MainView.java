package ru.mail;


import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import ru.mail.view.LazyPaperCardList;




/**
 * User: M.Belski@sam-solutions.com
 * Date: 27.11.2019
 */

@Route
@Push
@UIScoped
public class MainView extends VerticalLayout implements RouterLayout {

    public MainView() {
        add(new LazyPaperCardList());
        }

}
