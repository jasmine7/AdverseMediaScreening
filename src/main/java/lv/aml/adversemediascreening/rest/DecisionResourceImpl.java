package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.decision.*;
import lv.aml.adversemediascreening.core.dto.CreateDecisionListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/decisions")
public class DecisionResourceImpl implements DecisionResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(DecisionResourceImpl.class);

    @Autowired
    public DecisionResourceImpl(CommandExecutor executor, ObjectMapper mapper) {
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response create(CreateDecisionListDTO createDecisionListDTO) throws Exception {
        try {
            LOGGER.info("DecisionResourceImpl start");
            AddDecisionsCommand command = new AddDecisionsCommand(createDecisionListDTO.getUser(),
                    createDecisionListDTO.getDecisions());
            AddDecisionsResult result = executor.execute(command);
            LOGGER.info("DecisionResourceImpl end");
            return Response.ok().entity(mapper.writeValueAsString(result.getResultDecisions())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e)).build();
        }
    }
}
