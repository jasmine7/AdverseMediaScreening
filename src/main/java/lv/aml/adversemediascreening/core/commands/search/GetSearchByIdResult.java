package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.SearchDTO;

public class GetSearchByIdResult implements DomainCommandResult {

    private SearchDTO search;

    public GetSearchByIdResult(SearchDTO search) {
        this.search = search;
    }

    public SearchDTO getSearch() {
        return search;
    }
}
