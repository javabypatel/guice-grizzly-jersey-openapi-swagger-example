package com.javabypatel.config;

import com.google.inject.Injector;
import com.javabypatel.resource.GreetResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class H2KToGuiceModule extends AbstractBinder {

    private Injector injector;

    H2KToGuiceModule(Injector injector) {
        this.injector = injector;
    }

    @Override
    protected void configure() {
        bind(injector.getInstance(OpenApiResource.class)).to(OpenApiResource.class);
        bind(injector.getInstance(GreetResource.class)).to(GreetResource.class);
    }
}
