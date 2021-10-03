package lv.aml.adversemediascreening.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.aml.adversemediascreening.core.commands.CommandExecutor;
import lv.aml.adversemediascreening.core.commands.result.GetAllResultsBySearchIdCommand;
import lv.aml.adversemediascreening.core.commands.result.GetAllResultsBySearchIdResult;
import lv.aml.adversemediascreening.core.commands.search.*;
import lv.aml.adversemediascreening.core.dto.SearchDTO;
import lv.aml.adversemediascreening.core.services.search.SearchSorting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path("/searches")
public class SearchResourceImpl implements SearchResource {

    private final CommandExecutor executor;
    private final ObjectMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResourceImpl.class);

    @Autowired
    public SearchResourceImpl(CommandExecutor executor, ObjectMapper mapper){
        this.executor = executor;
        this.mapper = mapper;
    }

    @Override
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response doSearch(SearchDTO searchDTO) throws Exception {
        try {
            DoSearchCommand command = new DoSearchCommand(
                    searchDTO.getDateRestrict(),
                    searchDTO.getClient(),
                    searchDTO.getKeywords(),
                    searchDTO.getUser());
            DoSearchResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getSearchDTO())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getAll(@QueryParam(value = "page") int page,
                           @QueryParam(value = "size") int size,
                           @QueryParam(value = "sorting") SearchSorting sorting,
                           @QueryParam(value = "direction") Sort.Direction direction) throws Exception {
        try {
            GetAllSearchesCommand command = new GetAllSearchesCommand(page, size, sorting, direction);
            GetAllSearchesResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getSearchPageable())).build();
        } catch (Exception e){
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{searchId}")
    public Response get(@PathParam("searchId") Long searchId) throws Exception {
        try {
            GetSearchByIdCommand command = new GetSearchByIdCommand(searchId);
            GetSearchByIdResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getSearch())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }

    @Override
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{searchId}/results")
    public Response getResults(@PathParam("searchId")Long searchId) throws Exception {
        try {
            GetAllResultsBySearchIdCommand command = new GetAllResultsBySearchIdCommand(searchId);
            GetAllResultsBySearchIdResult result = executor.execute(command);
            return Response.ok().entity(mapper.writeValueAsString(result.getResults())).build();
        } catch (Exception e) {
            return Response.serverError().entity(mapper.writeValueAsString(e.toString())).build();
        }
    }
}
