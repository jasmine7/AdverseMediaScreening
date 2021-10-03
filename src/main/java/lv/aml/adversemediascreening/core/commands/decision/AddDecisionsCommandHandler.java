package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.ResultDecisionConverter;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import lv.aml.adversemediascreening.core.services.decision.ResultDecisionFactory;
import lv.aml.adversemediascreening.core.services.result.SearchResultService;
import lv.aml.adversemediascreening.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddDecisionsCommandHandler implements DomainCommandHandler<AddDecisionsCommand, AddDecisionsResult> {

    private final ResultDecisionFactory resultDecisionFactory;
    private final ResultDecisionConverter resultDecisionConverter;
    private final UserService userService;
    private final SearchResultService searchResultService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddDecisionsCommandHandler.class);

    @Autowired
    public AddDecisionsCommandHandler(ResultDecisionFactory resultDecisionFactory,
                                      ResultDecisionConverter resultDecisionConverter,
                                      UserService userService,
                                      SearchResultService searchResultService) {
        this.resultDecisionFactory = resultDecisionFactory;
        this.resultDecisionConverter = resultDecisionConverter;
        this.userService = userService;
        this.searchResultService = searchResultService;
    }

    @Override
    public AddDecisionsResult execute(AddDecisionsCommand command) {
        LOGGER.info("AddDecisionsCommandHandler start");
        User user = userService.getById(command.getUser().getId());
        LOGGER.info("AddDecisionsCommandHandler - user id " + command.getUser().getId());
        List<ResultDecisionDTO> resultDecisions = new ArrayList<>();
        LOGGER.info("AddDecisionsCommandHandler - number of decisions " + command.getDecisions());
        command.getDecisions().forEach((searchResultId, decision) -> {
            LOGGER.info("Result id " + searchResultId);
            SearchResult searchResult = searchResultService.getById(searchResultId);
            ResultDecision resultDecision = resultDecisionFactory.create(searchResult, decision, ZonedDateTime.now(), user);
            resultDecisions.add(resultDecisionConverter.convertToDTO(resultDecision));
        });
        return new AddDecisionsResult(resultDecisions);
    }

    @Override
    public Class getCommandType() {
        return AddDecisionsCommand.class;
    }
}
