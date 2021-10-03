package lv.aml.adversemediascreening.core.dto;

import java.util.HashMap;

public class CreateDecisionListDTO {

    private UserDTO user;
    private HashMap<Long, Boolean> decisions;

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public HashMap<Long, Boolean> getDecisions() {
        return decisions;
    }

    public void setDecisions(HashMap<Long, Boolean> decisions) {
        this.decisions = decisions;
    }
}
