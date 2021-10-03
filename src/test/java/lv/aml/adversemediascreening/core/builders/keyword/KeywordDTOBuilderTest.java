package lv.aml.adversemediascreening.core.builders.keyword;

import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordDTOBuilder.*;

class KeywordDTOBuilderTest {

    private static final Long ID = 1L;
    private static final String NAME = RandomStringUtils.randomAlphabetic(15);

    @Test
    public void createKeywordDTOWithBuilderTest(){
        KeywordDTO keyword = createKeywordDTO()
                .withId(ID)
                .withName(NAME)
                .build();

        assertEquals(ID, keyword.getId());
        assertEquals(NAME, keyword.getName());
    }

}