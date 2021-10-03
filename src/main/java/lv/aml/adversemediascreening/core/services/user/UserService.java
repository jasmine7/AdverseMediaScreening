package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;

public interface UserService {

    User getById(Long id);

    UserDTO getUserDTOByUsername(String username);
}
