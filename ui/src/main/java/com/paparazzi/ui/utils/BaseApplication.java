package com.paparazzi.ui.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;

/**
 * @author Artem Arapov
 *
 */
public abstract class BaseApplication extends Application implements HttpServletRequestListener {

    public final void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
        ApplicationHolder.set(this);
        requestStart(request, response);
    }

    public final void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        try {
            requestEnd(request, response);
        } finally {
            ApplicationHolder.reset();
        }
    }

    public void requestEnd(HttpServletRequest request, HttpServletResponse response) {
    }

    public void requestStart(HttpServletRequest request, HttpServletResponse response) {
    }
}
