package lv.aml.adversemediascreening.core.builders.search;

import lv.aml.adversemediascreening.core.domain.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static lv.aml.adversemediascreening.core.builders.search.SearchBuilder.*;

class SearchBuilderTest {

    private static final Long ID = 1L;
    private static final ZonedDateTime CREATED_DATE = ZonedDateTime.now();
    private static final User USER = new User();
    private static final DateRestrict DATE_RESTRICT = DateRestrict.YEAR;
    private static final Client CLIENT = new Client();
    private static final List<Keyword> KEYWORDS = new ArrayList<>();
    private static final List<SearchResult> RESULTS = new ArrayList<>();
    private static final Integer RESULT_COUNT = 10;

    @Test
    public void createSearchWithBuilder(){
        Search search = createSearch()
                .withId(ID)
                .withCreatedDate(CREATED_DATE)
                .withUser(USER)
                .withDateRestrict(DATE_RESTRICT)
                .withClient(CLIENT)
                .withKeywords(KEYWORDS)
                .withSearchResults(RESULTS)
                .withResultCount(RESULT_COUNT)
                .build();

        assertEquals(ID, search.getId());
        assertEquals(CREATED_DATE, search.getCreatedDate());
        assertEquals(USER, search.getUser());
        assertEquals(DATE_RESTRICT, search.getDateRestrict());
        assertEquals(CLIENT, search.getClient());
        assertEquals(KEYWORDS, search.getKeywords());
        assertEquals(RESULTS, search.getResults());
        assertEquals(RESULT_COUNT, search.getResultCount());
    }
}