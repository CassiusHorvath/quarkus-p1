package com.quarkus;


import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class test {

    JSONObject obj = new JSONObject().put("nome","teste");


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest(){return obj.toString();}
}
