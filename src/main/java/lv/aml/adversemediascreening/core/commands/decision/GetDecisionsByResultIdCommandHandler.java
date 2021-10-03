package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.ResultDecisionConverter;
import lv.aml.adversemediascreening.core.dao.ResultDecisionDAO;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDecisionsByResultIdCommandHandler
        implements DomainCommandHandler<GetDecisionsByResultIdCommand, GetDecisionsByResultIdResult> {

    private final ResultDecisionDAO decisionDAO;
    private final ResultDecisionConverter decisionConverter;

    public GetDecisionsByResultIdCommandHandler(ResultDecisionDAO decisionDAO,
                                                ResultDecisionConverter decisionConverter) {
        this.decisionDAO = decisionDAO;
        this.decisionConverter = decisionConverter;
    }

    @Override
    public GetDecisionsByResultIdResult execute(GetDecisionsByResultIdCommand command) {
        List<ResultDecision> decisions = decisionDAO.findByResultIdAndFetchUserEagerly(command.getResultId());
        List<ResultDecisionDTO> dtos = decisionConverter.convertToDTO(decisions);
        return new GetDecisionsByResultIdResult(dtos);
    }

    @Override
    public Class getCommandType() {
        return GetDecisionsByResultIdCommand.class;
    }
}
