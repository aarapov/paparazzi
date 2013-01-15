package com.paparazzi.ui.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;

/**
 * Servlet of the application.
 * 
 * @author Artem Arapov
 *
 */
@SuppressWarnings("serial")
public class PaparazziApplicationServlet extends AbstractApplicationServlet {

    private WebApplicationContext applicationContext;
    private Class<? extends Application> applicationClass;
    private String applicationBean;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        applicationBean = servletConfig.getInitParameter("applicationBean");
        if (applicationBean == null) {
            throw new ServletException("ApplicationBean not specified in servlet parameters");
        }
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
        applicationClass = (Class<? extends Application>) applicationContext.getType(applicationBean);
    }
    
    @Override
    protected Application getNewApplication(HttpServletRequest request) throws ServletException {
        return (Application) applicationContext.getBean(applicationBean);
    }

    @Override
    protected Class<? extends Application> getApplicationClass() throws ClassNotFoundException {
        return applicationClass;
    }

}
