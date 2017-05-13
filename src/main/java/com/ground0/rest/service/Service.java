package com.ground0.rest.service;

import com.ground0.rest.dao.MessageDAO;
import com.ground0.rest.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by zer0 on 2/2/17.
 */

@Path("home")
public class Service {

    MessageDAO messageDAO = new MessageDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageDAO.getMessages();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloServer(Message message) {
        System.out.print(message == null ? "NULL" : message.getData());
        messageDAO.addMessage(message);
        return Response.ok().build();
    }

}
