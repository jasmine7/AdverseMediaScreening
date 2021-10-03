package lv.aml.adversemediascreening.core.commands.result;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import lv.aml.adversemediascreening.core.services.result.SearchResultService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllResultsBySearchIdCommandHandler
        implements DomainCommandHandler<GetAllResultsBySearchIdCommand, GetAllResultsBySearchIdResult> {

    private final SearchResultService searchResultService;

    public GetAllResultsBySearchIdCommandHandler(SearchResultService searchResultService) {
        this.searchResultService = searchResultService;
    }

    @Override
    public GetAllResultsBySearchIdResult execute(GetAllResultsBySearchIdCommand command) {
        List<SearchResultDTO> results = searchResultService.getAllBySearchId(command.getSearchId());
        return new GetAllResultsBySearchIdResult(results);
    }

    @Override
    public Class getCommandType() {
        return GetAllResultsBySearchIdCommand.class;
    }
}
