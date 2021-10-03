package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import lv.aml.adversemediascreening.core.domain.Keyword;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.base.Preconditions.*;

@Component
public class SearchValidatorImpl implements SearchValidator {

    @Override
    public void validateForCreate(DateRestrict dateRestrict, Client client, List<Keyword> keywords) {
        validateDateRestrict(dateRestrict);
        validateClient(client);
        validateKeywords(keywords);
    }

    private void validateDateRestrict(DateRestrict dateRestrict){
        checkNotNull(dateRestrict, "Date restrict must not be null");
    }

    private void validateClient(Client client){
        checkNotNull(client, "Client must not be null");
    }

    private void validateKeywords(List<Keyword> keywords){
        checkArgument(!keywords.isEmpty(), "Keyword list must not be empty");
    }
}
