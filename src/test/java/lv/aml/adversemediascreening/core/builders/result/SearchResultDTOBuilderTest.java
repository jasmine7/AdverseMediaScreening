package lv.aml.adversemediascreening.core.builders.result;

import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static lv.aml.adversemediascreening.core.builders.result.SearchResultDTOBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchResultDTOBuilderTest {

    private static final Long ID = 1L;
    private static final String TITLE = RandomStringUtils.randomAlphabetic(15);
    private static final String LINK = RandomStringUtils.randomAlphabetic(25);
    private static final String SNIPPET = RandomStringUtils.randomAlphabetic(50);

    @Test
    public void createSearchResultWithBuilder(){
        SearchResultDTO searchResult = createSearchResultDTO()
                .withId(ID)
                .withTitle(TITLE)
                .withLink(LINK)
                .withSnippet(SNIPPET)
                .build();

        assertEquals(ID, searchResult.getId());
        assertEquals(TITLE, searchResult.getTitle());
        assertEquals(LINK, searchResult.getLink());
        assertEquals(SNIPPET, searchResult.getSnippet());
    }

}