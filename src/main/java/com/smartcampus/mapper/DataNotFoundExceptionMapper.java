package com.smartcampus.mapper;

import com.smartcampus.exception.*;
import com.smartcampus.model.ErrorMessage;

import javax.ws.rs.ext.*;
import javax.ws.rs.core.*;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    public Response toResponse(DataNotFoundException ex) {
        return Response.status(404)
                .entity(new ErrorMessage(ex.getMessage(), 404, "docs"))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}