package com.HomeWork56;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginService {
    User user = new User("Anatolik", "123123");

    @GET
    @Path("/{userName}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkUser(@PathParam("userName") String userName, @PathParam("password") String password){
        User user1 = new User(userName, password);
        if(user.equals(user1))return "temporalkey";
        else return "Error";
    }


}
