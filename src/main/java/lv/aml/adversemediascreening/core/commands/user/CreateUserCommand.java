package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommand;
import lv.aml.adversemediascreening.core.dto.CreateUserDTO;

public class CreateUserCommand implements DomainCommand<CreateUserResult> {

    private CreateUserDTO user;

    public CreateUserCommand(CreateUserDTO user) {
        this.user = user;
    }

    public CreateUserDTO getUser() {
        return user;
    }
}
