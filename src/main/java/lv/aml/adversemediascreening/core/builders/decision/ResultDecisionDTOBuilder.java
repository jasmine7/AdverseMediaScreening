package lv.aml.adversemediascreening.core.builders.decision;

import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;

import java.time.ZonedDateTime;

public class ResultDecisionDTOBuilder {

    private Long id;
    private Boolean decision;
    private ZonedDateTime date;
    private UserDTO user;

    private ResultDecisionDTOBuilder(){

    }

    public static ResultDecisionDTOBuilder createResultDecisionDTO(){
        return new ResultDecisionDTOBuilder();
    }

    public ResultDecisionDTO build(){
        ResultDecisionDTO resultDecision = new ResultDecisionDTO();
        resultDecision.setId(id);
        resultDecision.setDecision(decision);
        resultDecision.setDate(date);
        resultDecision.setUser(user);
        return resultDecision;
    }

    public ResultDecisionDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ResultDecisionDTOBuilder withDecision(Boolean decision){
        this.decision = decision;
        return this;
    }

    public ResultDecisionDTOBuilder withDate(ZonedDateTime date){
        this.date = date;
        return this;
    }

    public ResultDecisionDTOBuilder withUser(UserDTO user){
        this.user = user;
        return this;
    }
}
