package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.UserDTO;

public class GetUserByUsernameResult implements DomainCommandResult {

    private UserDTO user;

    public GetUserByUsernameResult(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser(){
        return user;
    }
}
