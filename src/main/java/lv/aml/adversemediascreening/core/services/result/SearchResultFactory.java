package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.SearchResult;

public interface SearchResultFactory {

    SearchResult create(Search search,
                        String title,
                        String link,
                        String snippet);
}
