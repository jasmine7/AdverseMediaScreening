package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;

import java.util.List;

public class AddDecisionsResult implements DomainCommandResult {

    List<ResultDecisionDTO> resultDecisions;

    public AddDecisionsResult(List<ResultDecisionDTO> resultDecisions) {
        this.resultDecisions = resultDecisions;
    }

    public List<ResultDecisionDTO> getResultDecisions() {
        return resultDecisions;
    }
}
