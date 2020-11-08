package com.javabypatel.config;

import com.google.inject.Injector;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig  extends ResourceConfig {

    public JerseyConfig(Injector injector) {
        packages("com.javabypatel.resource");
        registerInstances(new H2KToGuiceModule(injector));
    }
}