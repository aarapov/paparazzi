package com.paparazzi.ui.utils;

import com.vaadin.Application;

/**
 * That class hold Application instabce in <code>ThreadLocal</code> variable.
 * 
 * @author Artem Arapov
 *
 */
public class ApplicationHolder {
    private static ThreadLocal<Application> holder = new ThreadLocal<Application>();

    /**
     * Set <code>Application</code> into the holder.
     * 
     * @param application
     * */
    public static void set(Application application) {
        holder.set(application);
    }

    /**
     * Get <code>Application</code> from holder.
     * 
     * @return application
     * */
    public static Application get() {
        return holder.get();
    }

    /**
     * Remove application from holder.
     * */
    public static void reset() {
        holder.remove();
    }
}
