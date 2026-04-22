package com.smartcampus.mapper;

import javax.ws.rs.ext.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.smartcampus.exception.SensorUnavailableException;

@Provider
public class SensorMapper implements ExceptionMapper<SensorUnavailableException> {
    public Response toResponse(SensorUnavailableException ex) {
        return Response.status(403)
                .entity(Map.of("error", "Sensor in maintenance"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}