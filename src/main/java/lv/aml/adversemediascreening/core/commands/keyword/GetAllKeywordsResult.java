package lv.aml.adversemediascreening.core.commands.keyword;

import lv.aml.adversemediascreening.core.commands.DomainCommandResult;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;

import java.util.List;

public class GetAllKeywordsResult implements DomainCommandResult {

    private List<KeywordDTO> keywordDTOs;

    public GetAllKeywordsResult(List<KeywordDTO> keywordDTOs){
        this.keywordDTOs = keywordDTOs;
    }

    public List<KeywordDTO> getKeywordDTOs() {
        return keywordDTOs;
    }
}
