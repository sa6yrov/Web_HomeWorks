package com.HomeWork56;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class numService {

    @GET
    @Path("/{num1}/{num2}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReturnSum getSum(@PathParam("num1") Integer num1,@PathParam("num2") Integer num2){
        return new ReturnSum(num1 + num2);
    }
}
