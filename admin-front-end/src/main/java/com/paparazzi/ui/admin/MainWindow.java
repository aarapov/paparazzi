package com.paparazzi.ui.admin;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * @author Artem Arapov
 *
 */
public class MainWindow extends Window {

    private static final long serialVersionUID = 1L;
    
    private HorizontalLayout topLayout = new HorizontalLayout();
    private HorizontalLayout contentLayout = new HorizontalLayout();

    public MainWindow() {
        super(AdminApplication.APPLICATION_TITLE);

        addComponent(new Label(AdminApplication.APPLICATION_TITLE));
    }
}
