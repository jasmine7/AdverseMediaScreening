package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.ws.rs.QueryParam;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("SELECT new lv.aml.adversemediascreening.core.dto.UserDTO(u.id, u.username, u.firstName, u.lastName) " +
            "from User u where u.username = :username")
    Optional<UserDTO> getUserDTOByUsername(@QueryParam("username") String username);
}
