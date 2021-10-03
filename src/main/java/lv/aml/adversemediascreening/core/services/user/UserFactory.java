package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.domain.User;

public interface UserFactory {

    User create (String username, String password, String firstName, String lastName);
}
