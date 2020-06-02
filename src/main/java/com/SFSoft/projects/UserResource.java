/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SFSoft.projects;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.SFSoft.models.User;
import com.SFSoft.services.UserService;

/**
 * @author raul
 */

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    
    UserService service = UserService.getInstance();
    
    @GET
    public List <User> getUsers()    {
        return service.getUsers();
    }
    
    @GET
    @Path("{id}")
    public User getUser (@PathParam("id")int id)    {
        return service.getUser(id);
    }
    
    @POST
    public User addUser (User user)  {
        return service.addUser(user);
    }
    
    @PUT
    @Path("{id}")
    public User updateUser (@PathParam("id")int id, User user)  {
        return service.updateUser(id, user);
    }
    
    @DELETE
    @Path("{id}")
    public void deleteUser (@PathParam("id")int id) {
        service.deleteUser(id);
    }
}
