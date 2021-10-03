package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class GetUserByUsernameCommand implements DomainCommand<GetUserByUsernameResult> {

    private String username;

    public GetUserByUsernameCommand(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
