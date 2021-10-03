package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.user.CreateUserCommand;
import lv.aml.adversemediascreening.core.commands.user.CreateUserResult;
import lv.aml.adversemediascreening.core.commands.user.GetUserByUsernameCommand;
import lv.aml.adversemediascreening.core.commands.user.GetUserByUsernameResult;
import lv.aml.adversemediascreening.core.dto.CreateUserDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/users")
public class UserResourceImpl implements UserResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    @Autowired
    public UserResourceImpl(CommandExecutor executor, ObjectMapper mapper) {
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(CreateUserDTO user) throws Exception {
        try{
            CreateUserCommand command = new CreateUserCommand(user);
            CreateUserResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getMessage())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e.getMessage())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{username}")
    public Response getByUsername(@PathParam("username") String username) throws Exception {
        try{
            GetUserByUsernameCommand command = new GetUserByUsernameCommand(username);
            GetUserByUsernameResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getUser())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e.getMessage())).build();
        }
    }
}
