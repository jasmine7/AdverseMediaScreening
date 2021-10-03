package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.SearchDTO;
import org.springframework.data.domain.Page;

public class GetAllSearchesResult implements DomainCommandResult {

    private Page<SearchDTO> searchPageable;

    public GetAllSearchesResult(Page<SearchDTO> searchPageable) {
        this.searchPageable = searchPageable;
    }

    public Page<SearchDTO> getSearchPageable() {
        return searchPageable;
    }
}
