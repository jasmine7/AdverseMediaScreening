package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.decision.GetDecisionsByResultIdCommand;
import lv.aml.adversemediascreening.core.commands.decision.GetDecisionsByResultIdResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/results")
public class ResultResourceImpl implements ResultResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    @Autowired
    public ResultResourceImpl(CommandExecutor executor, ObjectMapper mapper) {
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{resultId}/decisions")
    public Response getDecisions(@PathParam("resultId") Long resultId) throws Exception {
        try {
            GetDecisionsByResultIdCommand command = new GetDecisionsByResultIdCommand(resultId);
            GetDecisionsByResultIdResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getDecisions())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }
}
