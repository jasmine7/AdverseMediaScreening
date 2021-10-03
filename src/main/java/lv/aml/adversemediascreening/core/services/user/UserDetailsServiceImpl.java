package lv.aml.adversemediascreening.core.services.user;

import lv.aml.adversemediascreening.core.dao.UserDAO;
import lv.aml.adversemediascreening.core.domain.CustomUserDetails;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailsServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(login).orElseThrow(() -> new UserNotFoundException(login));
        return new CustomUserDetails(user);
    }
}
