package com.smartcampus.mapper;

import javax.ws.rs.ext.*;
import javax.ws.rs.core.*;
import java.util.*;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {
    public Response toResponse(Throwable ex) {
        return Response.status(500)
                .entity(Map.of("error", "Internal Server Error"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}