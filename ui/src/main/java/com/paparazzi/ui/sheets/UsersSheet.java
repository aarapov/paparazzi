package com.paparazzi.ui.sheets;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @author Artem Arapov
 *
 */

@org.springframework.stereotype.Component(value = "usersSheet")
@Scope(value = "prototype")
public class UsersSheet extends AbstractSheet {

    @Override
    protected Component buildTable() {
        HorizontalLayout tableLayout = new HorizontalLayout();
        tableLayout.setWidth("100%");
        tableLayout.setMargin(false, true, false, true); // Enable horizontal margins
        tableLayout.setSpacing(true);

        Table table = new Table();
        table.setSizeFull();
        table.setSelectable(true);
        table.addContainerProperty("Код", String.class, "");
        table.addContainerProperty("Имя", String.class, "");
        table.addContainerProperty("Фамилия", String.class, "");
        table.addContainerProperty("Логин", String.class, "");
        table.addContainerProperty("Филиал", String.class, "");

        tableLayout.addComponent(table);

        return tableLayout;
    }

    @Override
    protected Component buildMenu() {
        VerticalLayout menuLayout = new VerticalLayout();
        Button addButton = new Button("Добавить");
        addButton.setWidth("100");
        Button editButton = new Button("Изменить");
        editButton.setWidth("100");
        Button removeButton = new Button("Удалить");
        removeButton.setWidth("100");

        menuLayout.addComponent(addButton);
        menuLayout.addComponent(editButton);
        menuLayout.addComponent(removeButton);

        return menuLayout;
    }
}
