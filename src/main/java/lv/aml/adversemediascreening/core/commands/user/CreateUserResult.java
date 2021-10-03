package lv.aml.adversemediascreening.core.commands.user;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;

public class CreateUserResult implements DomainCommandResult {

    private String message;

    public CreateUserResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
