package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.SearchConverter;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.dto.SearchDTO;
import lv.aml.adversemediascreening.core.services.search.SearchService;
import org.springframework.stereotype.Component;

@Component
public class GetSearchByIdCommandHandler
        implements DomainCommandHandler<GetSearchByIdCommand, GetSearchByIdResult> {

    private SearchService searchService;
    private SearchConverter searchConverter;

    public GetSearchByIdCommandHandler(SearchService searchService, SearchConverter searchConverter) {
        this.searchService = searchService;
        this.searchConverter = searchConverter;
    }

    @Override
    public GetSearchByIdResult execute(GetSearchByIdCommand command) {
        Search search = searchService.getById(command.getId());
        SearchDTO dto = searchConverter.convertToDTO(search);
        return new GetSearchByIdResult(dto);
    }

    @Override
    public Class getCommandType() {
        return GetSearchByIdCommand.class;
    }
}
