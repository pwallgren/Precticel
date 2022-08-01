package com.petwal.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbeddedJettyServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedJettyServer.class);
    private final String configLocation;
    private final String path;

    public EmbeddedJettyServer(final String path, final String configLocation) {
        this.path = path;
        this.configLocation = configLocation;
    }

    public void start(final int port) throws Exception {

        LOGGER.info("Starting jetty server at port {}", port);

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocations(configLocation);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);

        final DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        final ServletHolder servletHolder = new ServletHolder(dispatcherServlet);
        contextHandler.addServlet(servletHolder, path);

        Server server = new Server(port);
        server.setHandler(contextHandler);
        server.start();
        LOGGER.info("Jetty server running at port {}", port);
        server.join();
    }


}
