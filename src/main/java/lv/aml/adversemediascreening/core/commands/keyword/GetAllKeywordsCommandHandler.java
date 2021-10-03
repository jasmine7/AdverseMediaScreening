package lv.aml.adversemediascreening.core.commands.keyword;

import lv.aml.adversemediascreening.core.commands.DomainCommandHandler;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import lv.aml.adversemediascreening.core.services.keyword.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllKeywordsCommandHandler
        implements DomainCommandHandler<GetAllKeywordsCommand, GetAllKeywordsResult> {

    private final KeywordService keywordService;

    @Autowired
    public GetAllKeywordsCommandHandler(KeywordService keywordService){
        this.keywordService = keywordService;
    }

    @Override
    public GetAllKeywordsResult execute(GetAllKeywordsCommand command) {
        List<KeywordDTO> dtos = keywordService.getAll();
        return new GetAllKeywordsResult(dtos);
    }

    @Override
    public Class getCommandType() {
        return GetAllKeywordsCommand.class;
    }
}
