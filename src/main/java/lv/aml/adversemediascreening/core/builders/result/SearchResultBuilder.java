package lv.aml.adversemediascreening.core.builders.result;

import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.SearchResult;

public class SearchResultBuilder {

    private Long id;
    private Search search;
    private String title;
    private String link;
    private String snippet;

    private SearchResultBuilder(){

    }

    public static SearchResultBuilder createSearchResult(){
        return new SearchResultBuilder();
    }

    public SearchResult build(){
        SearchResult result = new SearchResult();
        result.setId(id);
        result.setSearch(search);
        result.setTitle(title);
        result.setLink(link);
        result.setSnippet(snippet);
        return result;
    }

    public SearchResultBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public SearchResultBuilder withSearch(Search search){
        this.search = search;
        return this;
    }

    public SearchResultBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public SearchResultBuilder withLink(String link){
        this.link = link;
        return this;
    }

    public SearchResultBuilder withSnippet(String snippet){
        this.snippet = snippet;
        return this;
    }
}
