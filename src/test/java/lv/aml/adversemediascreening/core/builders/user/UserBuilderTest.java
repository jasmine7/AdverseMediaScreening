package lv.aml.adversemediascreening.core.builders.user;

import lv.aml.adversemediascreening.core.domain.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class UserBuilderTest {

    private static final Long ID = 1L;
    private static final String USERNAME = RandomStringUtils.randomAlphabetic(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphabetic(8);
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(15);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(15);

    @Test
    public void createUserWithBuilderTest(){
        User user = createUser()
                .withId(ID)
                .withUsername(USERNAME)
                .withPassword(PASSWORD)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .build();

        assertEquals(ID, user.getId());
        assertEquals(USERNAME, user.getUsername());
        assertEquals(PASSWORD, user.getPassword());
        assertEquals(FIRST_NAME, user.getFirstName());
        assertEquals(LAST_NAME, user.getLastName());
    }
}