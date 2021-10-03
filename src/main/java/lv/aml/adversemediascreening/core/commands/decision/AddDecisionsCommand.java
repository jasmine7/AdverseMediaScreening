package lv.aml.adversemediascreening.core.commands.decision;

import lv.aml.adversemediascreening.core.commands.DomainCommand;
import lv.aml.adversemediascreening.core.dto.UserDTO;

import java.util.HashMap;

public class AddDecisionsCommand implements DomainCommand<AddDecisionsResult> {

    private UserDTO user;
    private HashMap<Long, Boolean> decisions;

    public AddDecisionsCommand(UserDTO user, HashMap<Long, Boolean> decisions) {
        this.user = user;
        this.decisions = decisions;
    }

    public UserDTO getUser() {
        return user;
    }

    public HashMap<Long, Boolean> getDecisions() {
        return decisions;
    }
}
