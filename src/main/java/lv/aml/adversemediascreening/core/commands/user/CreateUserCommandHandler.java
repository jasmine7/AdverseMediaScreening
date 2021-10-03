package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.services.user.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements DomainCommandHandler<CreateUserCommand, CreateUserResult> {

    private final UserFactory userFactory;

    @Autowired
    public CreateUserCommandHandler(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public CreateUserResult execute(CreateUserCommand command) {
        User user = userFactory
                .create(command.getUser().getUsername(),
                        command.getUser().getPassword(),
                        command.getUser().getFirstName(),
                        command.getUser().getLastName());
        return new CreateUserResult("User created successfully");
    }

    @Override
    public Class getCommandType() {
        return CreateUserCommand.class;
    }
}
