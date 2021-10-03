package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommand;
import lv.aml.adversemediascreening.core.dto.ClientDTO;

public class AddClientCommand implements DomainCommand<AddClientResult> {

    private ClientDTO client;

    public AddClientCommand(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }
}
