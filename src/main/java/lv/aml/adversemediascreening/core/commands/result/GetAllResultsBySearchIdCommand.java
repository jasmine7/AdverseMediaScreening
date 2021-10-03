package lv.aml.adversemediascreening.core.commands.result;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class GetAllResultsBySearchIdCommand
        implements DomainCommand<GetAllResultsBySearchIdResult> {

    private Long searchId;

    public GetAllResultsBySearchIdCommand(Long searchId) {
        this.searchId = searchId;
    }

    public Long getSearchId() {
        return searchId;
    }
}
