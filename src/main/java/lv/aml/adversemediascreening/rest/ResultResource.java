package lv.aml.adversemediascreening.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/results")
public interface ResultResource {

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{resultId}/decisions")
    Response getDecisions(@PathParam("resultId") Long resultId) throws Exception;
}
