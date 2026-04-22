package com.smartcampus.mapper;

import javax.ws.rs.ext.*;
import javax.ws.rs.core.*;
import java.util.*;

import com.smartcampus.exception.LinkedResourceNotFoundException;

@Provider
public class LinkedMapper implements ExceptionMapper<LinkedResourceNotFoundException> {

    @Override
    public Response toResponse(LinkedResourceNotFoundException ex) {
        return Response.status(422)
                .entity(Map.of("error", "Room does not exist"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}