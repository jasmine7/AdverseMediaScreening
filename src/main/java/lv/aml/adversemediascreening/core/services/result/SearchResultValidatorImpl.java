package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.domain.Search;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.StringUtils.*;

@Component
public class SearchResultValidatorImpl implements SearchResultValidator {

    @Override
    public void validateForCreate(Search search, String title, String link, String snippet) {
        validateSearch(search);
        validateTitle(title);
        validateLink(link);
        validateSnippet(snippet);
    }

    private void validateSearch(Search search){
        checkNotNull(search, "Search must not be null");
    }

    private void validateTitle(String title){
        checkArgument(!isBlank(title), "Title must not be null or empty");
    }

    private void validateLink(String link){
        checkArgument(!isBlank(link), "Link must not be null or empty");
    }

    private void validateSnippet(String snippet){
        checkArgument(!isBlank(snippet), "Snippet must not be null or empty");
    }
}
