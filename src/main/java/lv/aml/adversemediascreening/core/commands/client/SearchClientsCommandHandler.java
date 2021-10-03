package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.ClientConverter;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import lv.aml.adversemediascreening.core.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchClientsCommandHandler implements DomainCommandHandler<SearchClientsCommand, SearchClientsResult> {

    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @Autowired
    public SearchClientsCommandHandler(ClientService clientService, ClientConverter clientConverter) {
        this.clientService = clientService;
        this.clientConverter = clientConverter;
    }

    @Override
    public SearchClientsResult execute(SearchClientsCommand command) {
        List<Client> clients = clientService.searchFirstFiveClients(command.getSearchCriteria());
        List<ClientDTO> dtos = clientConverter.convertToDTO(clients);
        return new SearchClientsResult(dtos);
    }

    @Override
    public Class getCommandType() {
        return SearchClientsCommand.class;
    }
}
