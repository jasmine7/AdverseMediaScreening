package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.SearchConverter;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import lv.aml.adversemediascreening.core.services.client.ClientService;
import lv.aml.adversemediascreening.core.services.keyword.KeywordService;
import lv.aml.adversemediascreening.core.services.search.SearchFactory;
import lv.aml.adversemediascreening.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoSearchCommandHandler implements DomainCommandHandler<DoSearchCommand, DoSearchResult> {

    private final ClientService clientService;
    private final KeywordService keywordService;
    private final SearchFactory searchFactory;
    private final SearchConverter searchConverter;
    private final UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DoSearchCommandHandler.class);

    @Autowired
    public DoSearchCommandHandler(ClientService clientService,
                                  KeywordService keywordService,
                                  SearchFactory searchFactory,
                                  SearchConverter searchConverter,
                                  UserService userService){
        this.clientService = clientService;
        this.keywordService = keywordService;
        this.searchFactory = searchFactory;
        this.searchConverter = searchConverter;
        this.userService = userService;
    }

    @Override
    public DoSearchResult execute(DoSearchCommand command){
        Client client = clientService.getById(command.getClient().getId());

        List<Keyword> keywords = new ArrayList<>();
        for(KeywordDTO keywordDTO: command.getKeywords()){
            keywords.add(keywordService.getById(keywordDTO.getId()));
        }

        User user = userService.getById(command.getUser().getId());

        Search search = searchFactory.create(
                user,
                command.getDateRestrict(),
                client,
                keywords
        );

        return new DoSearchResult(searchConverter.convertToDTO(search));
    }

    @Override
    public Class getCommandType() {
        return DoSearchCommand.class;
    }
}
