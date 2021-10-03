package lv.aml.adversemediascreening.rest;

import lv.aml.adversemediascreening.core.dto.CreateDecisionListDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/decisions")
public interface DecisionResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response create(CreateDecisionListDTO createDecisionListDTO) throws Exception;
}
