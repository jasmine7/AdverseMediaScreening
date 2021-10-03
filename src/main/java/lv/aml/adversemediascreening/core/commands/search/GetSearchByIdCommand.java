package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class GetSearchByIdCommand implements DomainCommand<GetSearchByIdResult> {

    private Long id;

    public GetSearchByIdCommand(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
