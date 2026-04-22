package com.smartcampus.filter;

import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOGGER =
            Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext request) {
        LOGGER.info("HTTP " + request.getMethod() +
                " " + request.getUriInfo().getPath());
    }

    @Override
    public void filter(ContainerRequestContext req,
                       ContainerResponseContext res) {
        LOGGER.info("Response Status: " + res.getStatus());
    }
}