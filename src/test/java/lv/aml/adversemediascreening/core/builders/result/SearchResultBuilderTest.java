package lv.aml.adversemediascreening.core.builders.result;

import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;

class SearchResultBuilderTest {

    private static final Long ID = 1L;
    private static final Search SEARCH = new Search();
    private static final String TITLE = RandomStringUtils.randomAlphabetic(15);
    private static final String LINK = RandomStringUtils.randomAlphabetic(25);
    private static final String SNIPPET = RandomStringUtils.randomAlphabetic(50);

    @Test
    public void createSearchResultWithBuilder(){
        SearchResult searchResult = createSearchResult()
                .withId(ID)
                .withSearch(SEARCH)
                .withTitle(TITLE)
                .withLink(LINK)
                .withSnippet(SNIPPET)
                .build();

        assertEquals(ID, searchResult.getId());
        assertEquals(SEARCH, searchResult.getSearch());
        assertEquals(TITLE, searchResult.getTitle());
        assertEquals(LINK, searchResult.getLink());
        assertEquals(SNIPPET, searchResult.getSnippet());
    }

}