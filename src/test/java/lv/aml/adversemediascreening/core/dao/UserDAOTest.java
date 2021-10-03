package lv.aml.adversemediascreening.core.dao;

import jdk.nashorn.internal.runtime.options.Option;
import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
class UserDAOTest extends DomainDAOTest {

    private final UserDAO userDAO;

    @Autowired
    public UserDAOTest(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Test
    @Transactional
    public void createUserTest() {
        User user = createUserForTest();
        assertNull(user.getId());
        userDAO.save(user);
        assertNotNull(user.getId());
    }

    @Test
    @Transactional
    public void getUserByIdTest() {
        User user = createUserForTest();
        assertNull(user.getId());
        userDAO.save(user);
        assertNotNull(user.getId());
        Optional<User> fromDB = userDAO.findById(user.getId());

        assertEquals(user.getUsername(), fromDB.get().getUsername());
        assertEquals(user.getFirstName(), fromDB.get().getFirstName());
        assertEquals(user.getLastName(), fromDB.get().getLastName());
        assertEquals(user.getPassword(), fromDB.get().getPassword());
    }

    @Test
    @Transactional
    public void getUserByUsernameTest() {
        User user = createUserForTest();
        assertNull(user.getId());
        userDAO.save(user);
        assertNotNull(user.getId());
        Optional<User> fromDB = userDAO.findByUsername(user.getUsername());

        assertEquals(user.getId(), fromDB.get().getId());
        assertEquals(user.getFirstName(), fromDB.get().getFirstName());
        assertEquals(user.getLastName(), fromDB.get().getLastName());
        assertEquals(user.getPassword(), fromDB.get().getPassword());
    }

    @Test
    @Transactional
    public void getUserDTOByUsernameTest() {
        User user = createUserForTest();
        assertNull(user.getId());
        userDAO.save(user);
        assertNotNull(user.getId());
        Optional<UserDTO> fromDB = userDAO.getUserDTOByUsername(user.getUsername());

        assertEquals(user.getId(), fromDB.get().getId());
        assertEquals(user.getFirstName(), fromDB.get().getFirstName());
        assertEquals(user.getLastName(), fromDB.get().getLastName());
    }
}