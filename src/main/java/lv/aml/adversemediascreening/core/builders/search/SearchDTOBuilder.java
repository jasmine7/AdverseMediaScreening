package lv.aml.adversemediascreening.core.builders.search;

import lv.aml.adversemediascreening.core.dto.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;

import java.time.ZonedDateTime;
import java.util.List;

public class SearchDTOBuilder {

    private Long id;
    private ZonedDateTime createdDate;
    private UserDTO user;
    private DateRestrict dateRestrict;
    private ClientDTO client;
    private List<KeywordDTO> keywords;
    private Integer resultCount;

    private SearchDTOBuilder(){

    }

    public static SearchDTOBuilder createSearchDTO(){
        return new SearchDTOBuilder();
    }

    public SearchDTO build(){
        SearchDTO search = new SearchDTO();
        search.setId(id);
        search.setCreatedDate(createdDate);
        search.setUser(user);
        search.setDateRestrict(dateRestrict);
        search.setClient(client);
        search.setKeywords(keywords);
        search.setResultCount(resultCount);
        return search;
    }

    public SearchDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public SearchDTOBuilder withCreatedDate(ZonedDateTime createdDate){
        this.createdDate = createdDate;
        return this;
    }

    public SearchDTOBuilder withUser(UserDTO user){
        this.user = user;
        return this;
    }

    public SearchDTOBuilder withDateRestrict(DateRestrict dateRestrict){
        this.dateRestrict = dateRestrict;
        return this;
    }

    public SearchDTOBuilder withClient(ClientDTO client){
        this.client = client;
        return this;
    }

    public SearchDTOBuilder withKeywords(List<KeywordDTO> keywords){
        this.keywords = keywords;
        return this;
    }

    public SearchDTOBuilder withResultCount(Integer resultCount){
        this.resultCount = resultCount;
        return this;
    }
}
