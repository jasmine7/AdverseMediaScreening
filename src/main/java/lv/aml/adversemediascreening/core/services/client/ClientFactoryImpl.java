package lv.aml.adversemediascreening.core.services.client;

import lv.aml.adversemediascreening.core.dao.ClientDAO;
import lv.aml.adversemediascreening.core.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;

@Service
public class ClientFactoryImpl implements ClientFactory {

    private final ClientDAO clientDAO;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientFactoryImpl.class);

    @Autowired
    public ClientFactoryImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Client create(String name, String type, String registrationNumber, String country) {
        Client client = createClient()
                .withName(name)
                .withType(type)
                .withRegistrationNumber(registrationNumber)
                .withCountry(country)
                .build();
        clientDAO.save(client);
        LOGGER.info("Client saved with id " + client.getId());
        return client;
    }
}
