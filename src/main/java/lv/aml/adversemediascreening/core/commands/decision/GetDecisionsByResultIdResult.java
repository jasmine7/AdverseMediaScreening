package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;

import java.util.List;

public class GetDecisionsByResultIdResult implements DomainCommandResult {

    private List<ResultDecisionDTO> decisions;

    public GetDecisionsByResultIdResult(List<ResultDecisionDTO> decisions) {
        this.decisions = decisions;
    }

    public List<ResultDecisionDTO> getDecisions() {
        return decisions;
    }
}
