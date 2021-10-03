package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import lv.aml.adversemediascreening.core.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByUsernameCommandHandler
        implements DomainCommandHandler<GetUserByUsernameCommand, GetUserByUsernameResult> {

    private final UserService userService;

    @Autowired
    public GetUserByUsernameCommandHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public GetUserByUsernameResult execute(GetUserByUsernameCommand command) {
        UserDTO user = userService.getUserDTOByUsername(command.getUsername());
        return new GetUserByUsernameResult(user);
    }

    @Override
    public Class getCommandType() {
        return GetUserByUsernameCommand.class;
    }
}
