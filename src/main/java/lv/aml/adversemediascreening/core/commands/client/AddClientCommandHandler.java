package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.converters.ClientConverter;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import lv.aml.adversemediascreening.core.services.client.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddClientCommandHandler
        implements DomainCommandHandler<AddClientCommand, AddClientResult> {

    private final ClientFactory clientFactory;
    private final ClientConverter clientConverter;

    @Autowired
    public AddClientCommandHandler(ClientFactory clientFactory,
                                   ClientConverter clientConverter) {
        this.clientFactory = clientFactory;
        this.clientConverter = clientConverter;
    }

    @Override
    public AddClientResult execute(AddClientCommand command) {
        Client client = clientFactory
                .create(command.getClient().getName(),
                        command.getClient().getType(),
                        command.getClient().getRegistrationNumber(),
                        command.getClient().getCountry());
        ClientDTO dto = clientConverter.convertToDTO(client);
        return new AddClientResult(dto);
    }

    @Override
    public Class getCommandType() {
        return AddClientCommand.class;
    }
}
