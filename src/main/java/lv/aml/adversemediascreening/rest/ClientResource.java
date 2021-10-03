package lv.aml.adversemediascreening.rest;

import lv.aml.adversemediascreening.core.dto.ClientDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/clients")
public interface ClientResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response create(ClientDTO client) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{clientId}")
    Response get(@PathParam("clientId") Long clientId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/search-clients/{searchCriteria}")
    Response searchClients(@PathParam("searchCriteria") String searchCriteria) throws Exception;
}
