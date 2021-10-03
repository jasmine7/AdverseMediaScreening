package lv.aml.adversemediascreening.rest;

import lv.aml.adversemediascreening.core.dto.CreateUserDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/users")
public interface UserResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response create(CreateUserDTO user) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{username}")
    Response getByUsername(@PathParam("username") String username) throws Exception;
}
