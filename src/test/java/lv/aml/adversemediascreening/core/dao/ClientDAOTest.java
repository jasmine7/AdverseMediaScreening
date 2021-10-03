package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
class ClientDAOTest extends DomainDAOTest {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientDAOTest(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Test
    @Transactional
    public void getFirstFiveClientsBySearchCriteriaTest(){
        List<Client> clients = clientDAO.getFirstFiveClientsBySearchCriteria("Pro");
        Boolean checkSize = clients.size() >= 2;
        assertEquals(true, checkSize);
    }

    @Test
    @Transactional
    public void createClientTest(){
        Client client = createClientForTest();
        assertNull(client.getId());
        clientDAO.save(client);
        assertNotNull(client.getId());
    }

    @Test
    @Transactional
    public void getClientByIdTest(){
        Client client = createClientForTest();
        assertNull(client.getId());
        clientDAO.save(client);
        assertNotNull(client.getId());
        Optional<Client> fromDB = clientDAO.findById(client.getId());
        assertEquals(client.getId(), fromDB.get().getId());
        assertEquals(client.getName(), fromDB.get().getName());
        assertEquals(client.getType(), fromDB.get().getType());
        assertEquals(client.getRegistrationNumber(), fromDB.get().getRegistrationNumber());
        assertEquals(client.getCountry(), fromDB.get().getCountry());
    }
}