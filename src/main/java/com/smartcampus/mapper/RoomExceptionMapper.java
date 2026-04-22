package com.smartcampus.mapper;

import javax.ws.rs.ext.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.smartcampus.exception.RoomNotEmptyException;

@Provider
public class RoomExceptionMapper implements ExceptionMapper<RoomNotEmptyException> {
    public Response toResponse(RoomNotEmptyException ex) {
        return Response.status(409)
                .entity(Map.of("error", "Room has active sensors"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}