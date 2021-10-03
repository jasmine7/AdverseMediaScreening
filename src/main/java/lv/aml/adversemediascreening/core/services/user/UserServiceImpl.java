package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.dao.UserDAO;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import lv.aml.adversemediascreening.core.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getById(Long id) {
        return userDAO.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @Override
    public UserDTO getUserDTOByUsername(String username) {
        return userDAO.getUserDTOByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }
}
