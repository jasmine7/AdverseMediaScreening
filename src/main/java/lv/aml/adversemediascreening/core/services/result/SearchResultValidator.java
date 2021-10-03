package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.domain.Search;

public interface SearchResultValidator {

    void validateForCreate(Search search,
                           String title,
                           String link,
                           String snippet);
}
