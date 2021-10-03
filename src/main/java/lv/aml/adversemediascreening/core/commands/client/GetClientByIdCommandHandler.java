package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.ClientConverter;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import lv.aml.adversemediascreening.core.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientByIdCommandHandler
        implements DomainCommandHandler<GetClientByIdCommand, GetClientByIdResult> {

    private final ClientService clientService;
    private final ClientConverter clientConverter;

    @Autowired
    public GetClientByIdCommandHandler(ClientService clientService,
                                       ClientConverter clientConverter){
        this.clientService = clientService;
        this.clientConverter = clientConverter;
    }

    @Override
    public GetClientByIdResult execute(GetClientByIdCommand command) {
        Client client = clientService.getById(command.getId());
        ClientDTO dto = clientConverter.convertToDTO(client);
        return new GetClientByIdResult(dto);
    }

    @Override
    public Class getCommandType() {
        return GetClientByIdCommand.class;
    }
}
