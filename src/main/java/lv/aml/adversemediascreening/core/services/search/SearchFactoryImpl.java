package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.dao.SearchDAO;
import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.services.result.SearchResultFactory;
import lv.aml.adversemediascreening.searchengine.CustomSearchEngine;
import lv.aml.adversemediascreening.searchengine.CustomSearchItem;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.domain.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.search.SearchBuilder.*;

@Service
public class SearchFactoryImpl implements SearchFactory {

    private final SearchDAO searchDAO;
    private final SearchValidator searchValidator;
    private final CustomSearchEngine engine;
    private final SearchResultFactory resultFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFactoryImpl.class);

    @Autowired
    public SearchFactoryImpl(SearchDAO searchDAO,
                             SearchValidator searchValidator,
                             CustomSearchEngine engine,
                             SearchResultFactory resultFactory){
        this.searchDAO = searchDAO;
        this.searchValidator = searchValidator;
        this.engine = engine;
        this.resultFactory = resultFactory;
    }

    @Override
    public Search create(User user,
                         DateRestrict dateRestrict,
                         Client client,
                         List<Keyword> keywords) {
        searchValidator.validateForCreate(dateRestrict, client, keywords);
        Search search = createSearch()
                .withCreatedDate(ZonedDateTime.now())
                .withUser(user)
                .withDateRestrict(dateRestrict)
                .withClient(client)
                .withKeywords(keywords)
                .build();
        searchDAO.save(search);

        LOGGER.info("Search saved with id " + search.getId());

        Integer resultCount = doSearchAndSaveResults(search);
        search.setResultCount(resultCount);

        return search;
    }

    private Integer doSearchAndSaveResults(Search search) {
        List<CustomSearchItem> items = engine.doSearch(
                search.getDateRestrict(),
                search.getClient().getName(),
                createQuery(search.getKeywords()
                )
        );

        Integer resultCount = items.size();

        if(resultCount > 0){
            for (CustomSearchItem item: items){
                resultFactory.create(
                        search,
                        item.getTitle(),
                        item.getLink(),
                        item.getSnippet()
                );
            }
        }
        setResultCount(search, resultCount);

        return resultCount;
    }

    private String createQuery(List<Keyword> keywords){
        StringBuilder query = new StringBuilder();
        for (Keyword keyword: keywords) {
            if(query.length() == 0){
                query.append(keyword.getName());
            } else {
                query.append(" OR ").append(keyword.getName());
            }
        }
        return query.toString();
    }

    private void setResultCount(Search search, Integer resultCount) {
        if(search.getResultCount() == null || !search.getResultCount().equals(resultCount)){
            searchDAO.setResultCount(search.getId(), resultCount);
        }
    }
}
