package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommand;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import lv.aml.adversemediascreening.searchengine.DateRestrict;

import java.util.List;

public class DoSearchCommand implements DomainCommand<DoSearchResult> {

    private DateRestrict dateRestrict;
    private ClientDTO client;
    private List<KeywordDTO> keywords;
    private UserDTO user;

    public DoSearchCommand(DateRestrict dateRestrict,
                           ClientDTO client,
                           List<KeywordDTO> keywords,
                           UserDTO user){
        this.dateRestrict = dateRestrict;
        this.client = client;
        this.keywords = keywords;
        this.user = user;
    }

    public DateRestrict getDateRestrict() {
        return dateRestrict;
    }

    public ClientDTO getClient() {
        return client;
    }

    public List<KeywordDTO> getKeywords() {
        return keywords;
    }

    public UserDTO getUser() {
        return user;
    }
}
