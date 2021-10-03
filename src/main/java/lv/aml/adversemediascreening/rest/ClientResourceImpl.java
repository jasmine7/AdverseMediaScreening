package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.client.*;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/clients")
public class ClientResourceImpl implements ClientResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    @Autowired
    public ClientResourceImpl(CommandExecutor executor,
                              ObjectMapper mapper){
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(ClientDTO client) throws Exception {
        try {
            AddClientCommand command = new AddClientCommand(client);
            AddClientResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getClient())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e)).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{clientId}")
    public Response get(@PathParam("clientId") Long clientId) throws Exception {
        try {
            GetClientByIdCommand command = new GetClientByIdCommand(clientId);
            GetClientByIdResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getClient())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e)).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/search-clients/{searchCriteria}")
    public Response searchClients(@PathParam("searchCriteria") String searchCriteria) throws Exception {
        try {
            SearchClientsCommand command = new SearchClientsCommand(searchCriteria);
            SearchClientsResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getClients())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e)).build();
        }
    }
}
