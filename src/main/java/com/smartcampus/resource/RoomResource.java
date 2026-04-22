package com.smartcampus.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.smartcampus.model.*;
import com.smartcampus.store.DataStore;
import com.smartcampus.exception.DataNotFoundException;
import com.smartcampus.exception.RoomNotEmptyException;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    @GET
    public Collection<Room> getAll() {
        return DataStore.rooms.values();
    }

    @POST
    public Response create(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return Response.status(201).entity(room).build();
    }

    @GET
    @Path("/{id}")
    public Room get(@PathParam("id") String id) {
        Room room = DataStore.rooms.get(id);
        if (room == null) throw new DataNotFoundException("Room not found");
        return room;
    }

    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {

        Room room = DataStore.rooms.get(id);

        if (room == null)
            throw new DataNotFoundException("Room not found");


        if (!room.getSensorIds().isEmpty()) {
            throw new RoomNotEmptyException();
        }

        DataStore.rooms.remove(id);
        return Response.ok().build();
    }
}