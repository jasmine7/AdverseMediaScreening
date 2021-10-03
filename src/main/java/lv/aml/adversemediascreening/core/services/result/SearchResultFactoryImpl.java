package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.dao.SearchResultDAO;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;

@Service
public class SearchResultFactoryImpl implements SearchResultFactory {

    private final SearchResultDAO searchResultDAO;
    private final SearchResultValidator searchResultValidator;

    @Autowired
    public SearchResultFactoryImpl(SearchResultDAO searchResultDAO,
                                   SearchResultValidator searchResultValidator){
        this.searchResultDAO = searchResultDAO;
        this.searchResultValidator = searchResultValidator;
    }

    @Override
    public SearchResult create(Search search, String title, String link, String snippet) {
        searchResultValidator.validateForCreate(search, title, link, snippet);
        SearchResult result = createSearchResult()
                .withSearch(search)
                .withTitle(title)
                .withSnippet(snippet)
                .withLink(link)
                .build();
        searchResultDAO.save(result);
        return result;
    }
}
