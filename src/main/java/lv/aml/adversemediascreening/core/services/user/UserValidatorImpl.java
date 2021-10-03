package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

@Component
public class UserValidatorImpl implements UserValidator {

    private final UserDAO userDAO;

    @Autowired
    public UserValidatorImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void validateForCreate(String username, String password, String firstName, String lastName) {
        validateUsername(username);
        validatePassword(password);
        validateFirstName(firstName);
        validateLastName(lastName);
    }

    private void validateUsername(String username){
        checkArgument(!userDAO.findByUsername(username).isPresent(),
                "User with username " + username + " already exists.");
        checkArgument(!isBlank(username), "Username must not be empty.");
        checkNotNull(username, "Username must not be null.");
        checkArgument(username.length() >= 4, "Username length must be 4 to 10 characters");
        checkArgument(username.length() <= 10, "Username length must be 4 to 10 characters");
    }

    private void validatePassword(String password){
        checkArgument(!isBlank(password), "Password must not be empty.");
        checkNotNull(password, "Password must not be null.");
        checkArgument(password.length() >= 4, "Password length must be 4 to 10 characters");
        checkArgument(password.length() <= 10, "Password length must be 4 to 10 characters");
    }

    private void validateFirstName(String firstName){
        checkArgument(!isBlank(firstName), "First name must not be empty.");
        checkNotNull(firstName, "First name must not be null.");
    }

    private void validateLastName(String lastName){
        checkArgument(!isBlank(lastName), "Last name must not be empty.");
        checkNotNull(lastName, "Last name must not be null.");
    }
}
