package com.javabypatel;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.javabypatel.config.JerseyConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;

public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/OpenAPIExample/");
    private static final String RESOURCE_PATH = "greet?name=JavaByPatel";

    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new AppModule());
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                    BASE_URI,
                    new JerseyConfig(injector),
                    false);

            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
            server.start();

            System.out.println(String.format("Application started. Open %s%s%n", BASE_URI, RESOURCE_PATH));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}