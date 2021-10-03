package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.ClientDTO;

import java.util.List;

public class SearchClientsResult implements DomainCommandResult {

    private List<ClientDTO> clients;

    public SearchClientsResult(List<ClientDTO> clients) {
        this.clients = clients;
    }

    public List<ClientDTO> getClients() {
        return clients;
    }
}
