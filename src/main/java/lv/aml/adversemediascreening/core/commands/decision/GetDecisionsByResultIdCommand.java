package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class GetDecisionsByResultIdCommand implements DomainCommand<GetDecisionsByResultIdResult> {

    private Long resultId;

    public GetDecisionsByResultIdCommand(Long resultId) {
        this.resultId = resultId;
    }

    public Long getResultId() {
        return resultId;
    }
}
