package lv.aml.adversemediascreening.core.commands.client;

import lv.aml.adversemediascreening.core.commands.DomainCommand;

public class SearchClientsCommand implements DomainCommand<SearchClientsResult> {

    private String searchCriteria;

    public SearchClientsCommand(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }
}
