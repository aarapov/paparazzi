package com.paparazzi.ui.sheets;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author Artem Arapov
 *
 */
public abstract class AbstractSheet {

    public Component buildSheet() {
        HorizontalLayout contentLayout = new HorizontalLayout();
        contentLayout.setWidth("100%");
        contentLayout.setMargin(false, true, false, true); // Enable horizontal margins
        contentLayout.setSpacing(true);

        Component table = buildTable();
        Component menu = buildMenu();
        contentLayout.addComponent(table);
        contentLayout.addComponent(menu);
        contentLayout.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
        contentLayout.setComponentAlignment(menu, Alignment.MIDDLE_RIGHT);

        return contentLayout;
    }
    protected abstract Component buildTable();
    protected abstract Component buildMenu();
}
