package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;
import static lv.aml.adversemediascreening.core.builders.client.ClientDTOBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class ClientConverterTest {

    private static final Long ID = 1L;
    private static final String NAME = RandomStringUtils.randomAlphabetic(15);
    private static final String TYPE = RandomStringUtils.randomAlphabetic(5);
    private static final String REGISTRATION_NUMBER = RandomStringUtils.randomNumeric(10);
    private static final String COUNTRY = RandomStringUtils.randomAlphabetic(2);

    private final ClientConverter clientConverter;

    @Autowired
    public ClientConverterTest(ClientConverter clientConverter){
        this.clientConverter = clientConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        Client client = createClientToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        Client client = createClientToTest(null, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityConvertToDTOIfNameIsNullTest(){
        Client client = createClientToTest(ID, null, TYPE, REGISTRATION_NUMBER, COUNTRY);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityConvertToDTOIfTypeIsNullTest(){
        Client client = createClientToTest(ID, NAME, null, REGISTRATION_NUMBER, COUNTRY);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityConvertToDTOIfRegistrationNumberIsNullTest(){
        Client client = createClientToTest(ID, NAME, TYPE, null, COUNTRY);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityConvertToDTOICountryIsNullTest(){
        Client client = createClientToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, null);
        ClientDTO dto = clientConverter.convertToDTO(client);
        assertEquals(client.getId(), dto.getId());
        assertEquals(client.getName(), dto.getName());
        assertEquals(client.getType(), dto.getType());
        assertEquals(client.getRegistrationNumber(), dto.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        List<Client> clients = new ArrayList<>();
        clients.add(createClientToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY));
        List<ClientDTO> dtos = clientConverter.convertToDTO(clients);
        assertEquals(clients.get(0).getId(), dtos.get(0).getId());
        assertEquals(clients.get(0).getName(), dtos.get(0).getName());
        assertEquals(clients.get(0).getType(), dtos.get(0).getType());
        assertEquals(clients.get(0).getRegistrationNumber(), dtos.get(0).getRegistrationNumber());
        assertEquals(clients.get(0).getCountry(), dtos.get(0).getCountry());
    }

    @Test
    public void dtoConvertToEntityTest(){
        ClientDTO dto = createDTOToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        ClientDTO dto = createDTOToTest(null, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoConvertToEntityIfNameIsNullTest(){
        ClientDTO dto = createDTOToTest(ID, null, TYPE, REGISTRATION_NUMBER, COUNTRY);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoConvertToEntityIfTypeIsNullTest(){
        ClientDTO dto = createDTOToTest(ID, NAME, null, REGISTRATION_NUMBER, COUNTRY);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoConvertToEntityIfRegistrationNumberIsNullTest(){
        ClientDTO dto = createDTOToTest(ID, NAME, TYPE, null, COUNTRY);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoConvertToEntityIfCountryIsNullTest(){
        ClientDTO dto = createDTOToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, null);
        Client client = clientConverter.convertToEntity(dto);
        assertEquals(dto.getId(), client.getId());
        assertEquals(dto.getName(), client.getName());
        assertEquals(dto.getType(), client.getType());
        assertEquals(dto.getRegistrationNumber(), client.getRegistrationNumber());
        assertEquals(client.getCountry(), dto.getCountry());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        List<ClientDTO> dtos = new ArrayList<>();
        dtos.add(createDTOToTest(ID, NAME, TYPE, REGISTRATION_NUMBER, COUNTRY));
        List<Client> clients = clientConverter.convertToEntity(dtos);
        assertEquals(dtos.get(0).getId(), clients.get(0).getId());
        assertEquals(dtos.get(0).getName(), clients.get(0).getName());
        assertEquals(dtos.get(0).getType(), clients.get(0).getType());
        assertEquals(dtos.get(0).getRegistrationNumber(), clients.get(0).getRegistrationNumber());
        assertEquals(dtos.get(0).getCountry(), clients.get(0).getCountry());
    }

    private Client createClientToTest(Long id,
                                      String name,
                                      String type,
                                      String registrationNumber,
                                      String country){
        return createClient()
                .withId(id)
                .withName(name)
                .withType(type)
                .withRegistrationNumber(registrationNumber)
                .withCountry(country)
                .build();
    }

    private ClientDTO createDTOToTest(Long id,
                                      String name,
                                      String type,
                                      String registrationNumber,
                                      String country){
        return createClientDTO()
                .withId(id)
                .withName(name)
                .withType(type)
                .withRegistrationNumber(registrationNumber)
                .withCountry(country)
                .build();
    }
}