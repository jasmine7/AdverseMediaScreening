package lv.aml.adversemediascreening.core.builders.result;

import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;

public class SearchResultDTOBuilder {

    private Long id;
    private String title;
    private String link;
    private String snippet;
    private ResultDecisionDTO decision;

    private SearchResultDTOBuilder(){

    }

    public static SearchResultDTOBuilder createSearchResultDTO(){
        return new SearchResultDTOBuilder();
    }

    public SearchResultDTO build(){
        SearchResultDTO result = new SearchResultDTO();
        result.setId(id);
        result.setTitle(title);
        result.setLink(link);
        result.setSnippet(snippet);
        result.setDecision(decision);
        return result;
    }

    public SearchResultDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public SearchResultDTOBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public SearchResultDTOBuilder withLink(String link){
        this.link = link;
        return this;
    }

    public SearchResultDTOBuilder withSnippet(String snippet){
        this.snippet = snippet;
        return this;
    }

    public SearchResultDTOBuilder withDecision(ResultDecisionDTO decision){
        this.decision = decision;
        return this;
    }
}
