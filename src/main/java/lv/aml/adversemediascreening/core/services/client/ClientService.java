package lv.aml.adversemediascreening.core.services.client;

import lv.aml.adversemediascreening.core.domain.Client;

import java.util.List;

public interface ClientService {

    Client getById(Long id);
    List<Client> searchFirstFiveClients(String searchCriteria);
}
