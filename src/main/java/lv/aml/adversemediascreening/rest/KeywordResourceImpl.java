package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.keyword.GetAllKeywordsCommand;
import lv.aml.adversemediascreening.core.commands.keyword.GetAllKeywordsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/keywords")
public class KeywordResourceImpl implements KeywordResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    @Autowired
    public KeywordResourceImpl(CommandExecutor executor, ObjectMapper mapper){
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getKeywords() throws Exception {
        try{
            GetAllKeywordsCommand command = new GetAllKeywordsCommand();
            GetAllKeywordsResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getKeywordDTOs())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }
}
