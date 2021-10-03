package lv.aml.adversemediascreening.core.builders.search;

import lv.aml.adversemediascreening.core.domain.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;

import java.time.ZonedDateTime;
import java.util.List;

public class SearchBuilder {

    private Long id;
    private ZonedDateTime createdDate;
    private User user;
    private DateRestrict dateRestrict;
    private Client client;
    private List<Keyword> keywords;
    private List<SearchResult> results;
    private Integer resultCount;

    private SearchBuilder(){

    }

    public static SearchBuilder createSearch(){
        return new SearchBuilder();
    }

    public Search build(){
        Search search = new Search();
        search.setId(id);
        search.setCreatedDate(createdDate);
        search.setUser(user);
        search.setDateRestrict(dateRestrict);
        search.setClient(client);
        search.setKeywords(keywords);
        search.setResults(results);
        search.setResultCount(resultCount);
        return search;
    }

    public SearchBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public SearchBuilder withCreatedDate(ZonedDateTime createdDate){
        this.createdDate = createdDate;
        return this;
    }

    public SearchBuilder withUser(User user){
        this.user = user;
        return this;
    }

    public SearchBuilder withDateRestrict(DateRestrict dateRestrict){
        this.dateRestrict = dateRestrict;
        return this;
    }

    public SearchBuilder withClient(Client client){
        this.client = client;
        return this;
    }

    public SearchBuilder withKeywords(List<Keyword> keywords){
        this.keywords = keywords;
        return this;
    }

    public SearchBuilder withSearchResults(List<SearchResult> results){
        this.results = results;
        return this;
    }

    public SearchBuilder withResultCount(Integer resultCount){
        this.resultCount = resultCount;
        return this;
    }
}
