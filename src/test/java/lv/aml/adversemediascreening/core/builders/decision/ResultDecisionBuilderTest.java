package lv.aml.adversemediascreening.core.builders.decision;

import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultDecisionBuilderTest {

    private static final Long ID = 1L;
    private static final SearchResult RESULT = new SearchResult();
    private static final Boolean DECISION = Boolean.TRUE;
    private static final ZonedDateTime DATE = ZonedDateTime.now();
    private static final User USER = new User();

    @Test
    public void createDecisionWithBuilderTest(){
        ResultDecision decision = createResultDecision()
                .withId(ID)
                .withResult(RESULT)
                .withDecision(DECISION)
                .withDate(DATE)
                .withUser(USER)
                .build();

        assertEquals(ID, decision.getId());
        assertEquals(RESULT, decision.getResult());
        assertEquals(DECISION, decision.getDecision());
        assertEquals(DATE, decision.getDate());
        assertEquals(USER, decision.getUser());
    }
}