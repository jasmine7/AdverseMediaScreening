package lv.aml.adversemediascreening.core.builders.user;

import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static lv.aml.adversemediascreening.core.builders.user.UserDTOBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOBuilderTest {

    private static final Long ID = 1L;
    private static final String USERNAME = RandomStringUtils.randomAlphabetic(10);
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(15);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(15);

    @Test
    public void createUserDTOWithBuilderTest(){
        UserDTO userDTO = createUserDTO()
                .withId(ID)
                .withUsername(USERNAME)
                .withFirstName(FIRST_NAME)
                .withLastName(LAST_NAME)
                .build();

        assertEquals(ID, userDTO.getId());
        assertEquals(USERNAME, userDTO.getUsername());
        assertEquals(FIRST_NAME, userDTO.getFirstName());
        assertEquals(LAST_NAME, userDTO.getLastName());
    }
}