package lv.aml.adversemediascreening.core.builders.decision;

import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;

import java.time.ZonedDateTime;

public class ResultDecisionBuilder {

    private Long id;
    private SearchResult result;
    private Boolean decision;
    private ZonedDateTime date;
    private User user;

    private ResultDecisionBuilder(){

    }

    public static ResultDecisionBuilder createResultDecision(){
        return new ResultDecisionBuilder();
    }

    public ResultDecision build(){
        ResultDecision resultDecision = new ResultDecision();
        resultDecision.setId(id);
        resultDecision.setResult(result);
        resultDecision.setDecision(decision);
        resultDecision.setDate(date);
        resultDecision.setUser(user);
        return resultDecision;
    }

    public ResultDecisionBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ResultDecisionBuilder withResult(SearchResult result){
        this.result = result;
        return this;
    }

    public ResultDecisionBuilder withDecision(Boolean decision){
        this.decision = decision;
        return this;
    }

    public ResultDecisionBuilder withDate(ZonedDateTime date){
        this.date = date;
        return this;
    }

    public ResultDecisionBuilder withUser(User user){
        this.user = user;
        return this;
    }
}
