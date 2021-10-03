package lv.aml.adversemediascreening.rest;

import lv.aml.adversemediascreening.core.dto.SearchDTO;
import lv.aml.adversemediascreening.core.services.search.SearchSorting;
import org.springframework.data.domain.Sort;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/searches")
public interface SearchResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response doSearch(SearchDTO searchDTO) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Response getAll(@QueryParam(value = "page") int page,
                    @QueryParam(value = "size") int size,
                    @QueryParam(value = "sorting") SearchSorting sorting,
                    @QueryParam(value = "direction") Sort.Direction direction) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{searchId}")
    Response get(@PathParam("searchId") Long searchId) throws Exception;

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/{searchId}/results")
    Response getResults(@PathParam("searchId") Long searchId) throws Exception;
}
