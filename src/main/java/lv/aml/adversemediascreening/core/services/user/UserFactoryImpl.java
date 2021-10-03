package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.dao.UserDAO;
import lv.aml.adversemediascreening.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;

@Component
public class UserFactoryImpl implements UserFactory {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final UserValidator userValidator;

    @Autowired
    public UserFactoryImpl(UserDAO userDAO, PasswordEncoder passwordEncoder, UserValidator userValidator) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.userValidator = userValidator;
    }

    @Override
    public User create(String username, String password, String firstName, String lastName) {
        userValidator.validateForCreate(username, password, firstName, lastName);
        User user = createUser()
                .withUsername(username)
                .withPassword(passwordEncoder.encode(password))
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
        userDAO.save(user);
        return user;
    }

}
