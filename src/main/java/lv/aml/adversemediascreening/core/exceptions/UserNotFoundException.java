package lv.aml.adversemediascreening.core.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("User with username " + username + " not found");
    }

    public UserNotFoundException(Long id) {
        super("User with id " + id.toString() + " not found");
    }
}
