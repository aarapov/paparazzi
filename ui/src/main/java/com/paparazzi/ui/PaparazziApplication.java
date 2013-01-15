package com.paparazzi.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paparazzi.services.api.BranchService;
import com.paparazzi.ui.utils.BaseApplication;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

/**
 * @author Artem Arapov
 *
 */
@Component(value = "application")
@Scope(value = "prototype")
public class PaparazziApplication extends BaseApplication {

    private static final long serialVersionUID = 1L;

    public static final String APPLICATION_TITLE = "PAPARAZZI Administration console";

    @Autowired
    private BranchService service;
    
    @Override
    public void init() {
        VerticalLayout rootLayout = new VerticalLayout();
        final Window rootWindow = new Window(APPLICATION_TITLE, rootLayout);

        setMainWindow(rootWindow);

        rootLayout.setSizeFull();
        rootLayout.setMargin(false);

        HorizontalLayout top = new HorizontalLayout();
        top.setWidth("100%");
        top.setMargin(false, true, false, true); // Enable horizontal margins
        top.setSpacing(true);

        Label label = new Label();
        int count = service.findAll().size();
        label.setCaption("Records count: " + count);
        top.addComponent(label);

        rootWindow.addComponent(top);

        HorizontalLayout contentLayout = new HorizontalLayout();
        contentLayout.setWidth("100%");
        contentLayout.setMargin(false, true, false, true); // Enable horizontal margins
        contentLayout.setSpacing(true);
        
        rootWindow.addComponent(contentLayout);
        
        TabSheet contentSheet = new TabSheet();
        
        HorizontalLayout tableLayout = new HorizontalLayout();
        tableLayout.setWidth("100%");
        tableLayout.setMargin(false, true, false, true); // Enable horizontal margins
        tableLayout.setSpacing(true);

        rootWindow.addComponent(tableLayout);

        TabSheet tabSheet = new TabSheet();
        HorizontalLayout branchesLayout = new HorizontalLayout();
        branchesLayout.setWidth("100%");
        branchesLayout.setMargin(false, true, false, true); // Enable horizontal margins
        branchesLayout.setSpacing(true);
        HorizontalLayout usersLayout = new HorizontalLayout();

        Table table = new Table("Some Table");
        table.setSizeFull();
        table.setSelectable(true);
     // Add the table headers
        table.addContainerProperty("Филиал", String.class, "");
        table.addContainerProperty("Город", String.class, "0:00");
        table.addContainerProperty("Адрес", String.class, "");
        table.addContainerProperty("Тип", String.class, "");

        branchesLayout.addComponent(table);

        tabSheet.addTab(branchesLayout, "Филиалы");
        tabSheet.addTab(usersLayout, "Пользователи");
        tableLayout.addComponent(tabSheet);

        contentSheet.addTab(tabSheet, "Администрирование");
        contentLayout.addComponent(contentSheet);
        
        setTheme( "runo" );
    }

}
