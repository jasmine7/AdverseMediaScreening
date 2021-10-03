package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.SearchConverter;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.dto.SearchDTO;
import lv.aml.adversemediascreening.core.services.search.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class GetAllSearchesCommandHandler
        implements DomainCommandHandler<GetAllSearchesCommand, GetAllSearchesResult> {

    private final SearchService searchService;
    private final SearchConverter searchConverter;

    private static final Logger LOGGER = LoggerFactory.getLogger(GetAllSearchesCommandHandler.class);

    @Autowired
    public GetAllSearchesCommandHandler(SearchService searchService,
                                        SearchConverter searchConverter) {
        this.searchService = searchService;
        this.searchConverter = searchConverter;
    }

    @Override
    public GetAllSearchesResult execute(GetAllSearchesCommand command) {
        Page<Search> searches = searchService
                .getAll(command.getPage(), command.getSize(), command.getSorting(), command.getDirection());
        Page<SearchDTO> dtos = searches.map(searchConverter::convertToDTO);
        return new GetAllSearchesResult(dtos);
    }

    @Override
    public Class getCommandType() {
        return GetAllSearchesCommand.class;
    }
}
