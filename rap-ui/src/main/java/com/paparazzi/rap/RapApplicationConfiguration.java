package com.paparazzi.rap;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rwt.application.Application;
import org.eclipse.rwt.application.ApplicationConfiguration;
import org.eclipse.rwt.client.WebClient;

public class RapApplicationConfiguration implements ApplicationConfiguration {

    @Override
    public void configure(Application application) {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put(WebClient.PAGE_TITLE, "RAP Application");
        application.addEntryPoint("/rap_ui", ApplicationEntry.class, properties);
    }

}
