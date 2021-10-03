package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.ClientDTO;

public class GetClientByIdResult implements DomainCommandResult {

    private ClientDTO client;

    public GetClientByIdResult(ClientDTO client) {
        this.client = client;
    }

    public ClientDTO getClient() {
        return client;
    }
}
