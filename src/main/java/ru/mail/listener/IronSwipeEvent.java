package ru.mail.listener;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import ru.mail.model.Car;
import ru.mail.view.LazyPaperCardList;

/**
 * User: M.Belski@sam-solutions.com
 * Date: 13.02.2020
 */

@DomEvent("iron-swipe")
public class IronSwipeEvent extends ComponentEvent<LazyPaperCardList> {

    public IronSwipeEvent(LazyPaperCardList source, boolean fromClient) {
        super(source, fromClient);
    }

}
