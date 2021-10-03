package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class GetClientByIdCommand implements DomainCommand<GetClientByIdResult> {

    private Long id;

    public GetClientByIdCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
