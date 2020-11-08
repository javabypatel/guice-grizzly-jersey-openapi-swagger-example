package com.javabypatel;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
    }

    @Provides
    @Singleton
    OpenApiResource getOpenApiResource() {
        OpenApiResource openApiResource = new OpenApiResource();
        openApiResource.setConfigLocation("openapi-configuration.json");
        return openApiResource;
    }
}
