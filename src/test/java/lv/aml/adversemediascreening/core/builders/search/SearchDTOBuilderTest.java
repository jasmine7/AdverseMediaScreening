package lv.aml.adversemediascreening.core.builders.search;

import lv.aml.adversemediascreening.core.dto.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static lv.aml.adversemediascreening.core.builders.search.SearchDTOBuilder.*;

class SearchDTOBuilderTest {

    private static final Long ID = 1L;
    private static final ZonedDateTime CREATED_DATE = ZonedDateTime.now();
    private static final UserDTO USER = new UserDTO();
    private static final DateRestrict DATE_RESTRICT = DateRestrict.YEAR;
    private static final ClientDTO CLIENT = new ClientDTO();
    private static final List<KeywordDTO> KEYWORDS = new ArrayList<>();
    private static final Integer RESULT_COUNT = 10;

    @Test
    public void createSearchWithBuilder(){
        SearchDTO search = createSearchDTO()
                .withId(ID)
                .withCreatedDate(CREATED_DATE)
                .withUser(USER)
                .withDateRestrict(DATE_RESTRICT)
                .withClient(CLIENT)
                .withKeywords(KEYWORDS)
                .withResultCount(RESULT_COUNT)
                .build();

        assertEquals(ID, search.getId());
        assertEquals(CREATED_DATE, search.getCreatedDate());
        assertEquals(USER, search.getUser());
        assertEquals(DATE_RESTRICT, search.getDateRestrict());
        assertEquals(CLIENT, search.getClient());
        assertEquals(KEYWORDS, search.getKeywords());
        assertEquals(RESULT_COUNT, search.getResultCount());
    }
}