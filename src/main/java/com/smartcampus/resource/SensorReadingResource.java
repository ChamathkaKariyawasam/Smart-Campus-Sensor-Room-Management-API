package com.smartcampus.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import com.smartcampus.model.*;
import com.smartcampus.store.DataStore;
import com.smartcampus.exception.SensorUnavailableException;
import com.smartcampus.exception.DataNotFoundException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    private String sensorId;

    public SensorReadingResource(String id) {
        this.sensorId = id;
    }

    @GET
    public List<SensorReading> getAll() {
        return DataStore.readings.getOrDefault(sensorId, new ArrayList<>());
    }

    @POST
    public Response add(SensorReading reading) {

        Sensor sensor = DataStore.sensors.get(sensorId);

        if (sensor == null)
            throw new DataNotFoundException("Sensor not found");


        if ("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())) {
            throw new SensorUnavailableException();
        }

        DataStore.readings
                .computeIfAbsent(sensorId, k -> new ArrayList<>())
                .add(reading);


        sensor.setCurrentValue(reading.getValue());

        return Response.status(201).entity(reading).build();
    }
}