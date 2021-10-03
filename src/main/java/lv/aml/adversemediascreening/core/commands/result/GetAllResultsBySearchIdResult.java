package lv.aml.adversemediascreening.core.commands.result;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;

import java.util.List;

public class GetAllResultsBySearchIdResult implements DomainCommandResult {

    private List<SearchResultDTO> results;

    public GetAllResultsBySearchIdResult(List<SearchResultDTO> results) {
        this.results = results;
    }

    public List<SearchResultDTO> getResults() {
        return results;
    }
}
