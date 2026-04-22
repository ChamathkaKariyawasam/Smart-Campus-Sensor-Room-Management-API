package com.smartcampus.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.smartcampus.model.*;
import java.util.stream.Collectors;
import com.smartcampus.store.DataStore;
import com.smartcampus.exception.LinkedResourceNotFoundException;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    @POST
    public Response create(Sensor sensor) {

        if (!DataStore.rooms.containsKey(sensor.getRoomId())) {
            throw new LinkedResourceNotFoundException();
        }

        DataStore.sensors.put(sensor.getId(), sensor);

        DataStore.rooms.get(sensor.getRoomId())
                .getSensorIds().add(sensor.getId());

        return Response.status(201).entity(sensor).build();
    }


    @GET
    public Collection<Sensor> getAll(@QueryParam("type") String type) {

        if (type == null) return DataStore.sensors.values();

        return DataStore.sensors.values()
                .stream()
                .filter(s -> s.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }


    @Path("/{id}/readings")
    public SensorReadingResource readings(@PathParam("id") String id) {
        return new SensorReadingResource(id);
    }
}