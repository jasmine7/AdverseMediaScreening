package lv.aml.adversemediascreening.core.services.user;

public interface UserValidator {

    void validateForCreate(String username,
                           String password,
                           String firstName,
                           String lastName);
}
