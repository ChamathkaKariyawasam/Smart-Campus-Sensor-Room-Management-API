package com.smartcampus.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class DiscoveryResource {

    @GET
    public Map<String, Object> info() {
        Map<String, Object> info = new HashMap<>();
        info.put("api", "Smart Campus Sensor & Room Management API");
        info.put("version", "1.0.0");
        info.put("author", "Chamathka Kariyawasam");
        
        Map<String, String> map = new HashMap<>();
        map.put("rooms", "/api/v1/rooms");
        map.put("sensors", "/api/v1/sensors");
        
        info.put("map", map);
        return info;
    }
}