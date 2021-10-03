package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserDTOBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class UserConverterTest {

    private static final Long ID = 1L;
    private static final String USERNAME = RandomStringUtils.randomAlphabetic(10);
    private static final String PASSWORD = RandomStringUtils.randomAlphabetic(8);
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(15);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(15);

    private final UserConverter userConverter;

    @Autowired
    public UserConverterTest(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        User user = createUserForTest(ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME);
        UserDTO dto = userConverter.convertToDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        User user = createUserForTest(null, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME);
        UserDTO dto = userConverter.convertToDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void entityConvertToDTOIfUsernameIsNullTest(){
        User user = createUserForTest(ID, null, PASSWORD, FIRST_NAME, LAST_NAME);
        UserDTO dto = userConverter.convertToDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void entityConvertToDTOIfFirstNameIsNullTest(){
        User user = createUserForTest(ID, USERNAME, PASSWORD, null, LAST_NAME);
        UserDTO dto = userConverter.convertToDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void entityConvertToDTOIfLastNameIsNullTest(){
        User user = createUserForTest(ID, USERNAME, PASSWORD, FIRST_NAME, null);
        UserDTO dto = userConverter.convertToDTO(user);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        User user = createUserForTest(ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<UserDTO> dtos = userConverter.convertToDTO(users);

        assertEquals(users.get(0).getId(), dtos.get(0).getId());
        assertEquals(users.get(0).getUsername(), dtos.get(0).getUsername());
        assertEquals(users.get(0).getFirstName(), dtos.get(0).getFirstName());
        assertEquals(users.get(0).getLastName(), dtos.get(0).getLastName());
    }

    @Test
    public void dtoConvertToEntityTest(){
        UserDTO dto = createUserDTOForTest(ID, USERNAME, FIRST_NAME, LAST_NAME);
        User user = userConverter.convertToEntity(dto);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getUsername(), user.getUsername());
        assertEquals(dto.getFirstName(), user.getFirstName());
        assertEquals(dto.getLastName(), user.getLastName());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        UserDTO dto = createUserDTOForTest(null, USERNAME, FIRST_NAME, LAST_NAME);
        User user = userConverter.convertToEntity(dto);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getUsername(), user.getUsername());
        assertEquals(dto.getFirstName(), user.getFirstName());
        assertEquals(dto.getLastName(), user.getLastName());
    }

    @Test
    public void dtoConvertToEntityIfUsernameIsNullTest(){
        UserDTO dto = createUserDTOForTest(ID, null, FIRST_NAME, LAST_NAME);
        User user = userConverter.convertToEntity(dto);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getUsername(), user.getUsername());
        assertEquals(dto.getFirstName(), user.getFirstName());
        assertEquals(dto.getLastName(), user.getLastName());
    }

    @Test
    public void dtoConvertToEntityIfFirstNameIsNullTest(){
        UserDTO dto = createUserDTOForTest(ID, USERNAME, null, LAST_NAME);
        User user = userConverter.convertToEntity(dto);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getUsername(), user.getUsername());
        assertEquals(dto.getFirstName(), user.getFirstName());
        assertEquals(dto.getLastName(), user.getLastName());
    }

    @Test
    public void dtoConvertToEntityIfLastNameIsNullTest(){
        UserDTO dto = createUserDTOForTest(ID, USERNAME, FIRST_NAME, null);
        User user = userConverter.convertToEntity(dto);

        assertEquals(dto.getId(), user.getId());
        assertEquals(dto.getUsername(), user.getUsername());
        assertEquals(dto.getFirstName(), user.getFirstName());
        assertEquals(dto.getLastName(), user.getLastName());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        UserDTO dto = createUserDTOForTest(ID, USERNAME, FIRST_NAME, LAST_NAME);
        List<UserDTO> dtos = new ArrayList<>();
        dtos.add(dto);
        List<User> users = userConverter.convertToEntity(dtos);

        assertEquals(dtos.get(0).getId(), users.get(0).getId());
        assertEquals(dtos.get(0).getUsername(), users.get(0).getUsername());
        assertEquals(dtos.get(0).getFirstName(), users.get(0).getFirstName());
        assertEquals(dtos.get(0).getLastName(), users.get(0).getLastName());
    }

    private User createUserForTest(Long id,
                                   String username,
                                   String password,
                                   String firstName,
                                   String lastName){
        return createUser()
                .withId(id)
                .withUsername(username)
                .withPassword(password)
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }

    private UserDTO createUserDTOForTest(Long id,
                                         String username,
                                         String firstName,
                                         String lastName){
        return createUserDTO()
                .withId(id)
                .withUsername(username)
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }
}