package ru.mail;


import com.vaadin.cdi.annotation.UIScoped;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.ironlist.IronList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.shared.ui.Transport;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import ru.mail.view.LazyPaperCardList;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * User: M.Belski@sam-solutions.com
 * Date: 27.11.2019
 */

@Route
@Push
public class MainView extends VerticalLayout implements RouterLayout {


    @Inject
    public MainView(LazyPaperCardList lazyPaperCardList) {
        lazyPaperCardList.addIronSwipeListener( e -> System.out.println("FFFFFF"));
        add(lazyPaperCardList);
        }
}
