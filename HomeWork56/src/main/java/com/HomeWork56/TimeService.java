package com.HomeWork56;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@Path("/time")
public class TimeService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showTime(){
        return "" + new Date().toString();
    }
}
