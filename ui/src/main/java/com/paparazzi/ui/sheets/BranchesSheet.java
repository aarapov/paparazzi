package com.paparazzi.ui.sheets;

import org.springframework.context.annotation.Scope;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Artem Arapov
 *
 */
@org.springframework.stereotype.Component(value = "branchesSheet")
@Scope(value = "prototype")
public class BranchesSheet extends AbstractSheet {

    @Override
    protected Component buildTable() {
        Table table = new Table();
        table.setSizeFull();
        table.setSelectable(true);
        table.setImmediate(true);
     // Add the table headers
        table.addContainerProperty("Филиал", String.class, "");
        table.addContainerProperty("Город", String.class, "0:00");
        table.addContainerProperty("Адрес", String.class, "");
        table.addContainerProperty("Тип", String.class, "");

        return table;
    }

    @Override
    protected Component buildMenu() {
        VerticalLayout menuLayout = new VerticalLayout();
/*        menuLayout.setWidth("10%");*/
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
