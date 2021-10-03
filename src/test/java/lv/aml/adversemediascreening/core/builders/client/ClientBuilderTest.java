package lv.aml.adversemediascreening.core.builders.client;

import lv.aml.adversemediascreening.core.domain.Client;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;

class ClientBuilderTest {

    private static final Long ID = 1L;
    private static final String NAME = RandomStringUtils.randomAlphabetic(15);
    private static final String TYPE = RandomStringUtils.randomAlphabetic(5);
    private static final String REGISTRATION_NUMBER = RandomStringUtils.randomNumeric(10);
    private static final String COUNTRY = RandomStringUtils.randomAlphabetic(2);

    @Test
    public void createClientWithBuilderTest(){
        Client client = createClient()
                .withId(ID)
                .withName(NAME)
                .withType(TYPE)
                .withRegistrationNumber(REGISTRATION_NUMBER)
                .withCountry(COUNTRY)
                .build();

        assertEquals(ID, client.getId());
        assertEquals(NAME, client.getName());
        assertEquals(TYPE, client.getType());
        assertEquals(REGISTRATION_NUMBER, client.getRegistrationNumber());
        assertEquals(COUNTRY, client.getCountry());
    }

}