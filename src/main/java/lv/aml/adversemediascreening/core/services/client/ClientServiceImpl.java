package lv.aml.adversemediascreening.core.services.client;

import lv.aml.adversemediascreening.core.dao.ClientDAO;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientServiceImpl(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }

    @Override
    public Client getById(Long id) {
        return clientDAO.findById(id).orElseThrow(()-> new ClientNotFoundException(id));
    }

    @Override
    public List<Client> searchFirstFiveClients(String searchCriteria) {
        return clientDAO.getFirstFiveClientsBySearchCriteria(searchCriteria);
    }
}
