package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.SearchDTO;

public class DoSearchResult implements DomainCommandResult {

    private SearchDTO searchDTO;

    public DoSearchResult(SearchDTO searchDTO){
        this.searchDTO = searchDTO;
    }

    public SearchDTO getSearchDTO() {
        return searchDTO;
    }
}
