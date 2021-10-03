package lv.aml.adversemediascreening.core.builders.decision;

import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionDTOBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultDecisionDTOBuilderTest {

    private static final Long ID = 1L;
    private static final Boolean DECISION = Boolean.TRUE;
    private static final ZonedDateTime DATE = ZonedDateTime.now();
    private static final UserDTO USER = new UserDTO();

    @Test
    public void createDecisionDTOWithBuilderTest(){
        ResultDecisionDTO decisionDTO = createResultDecisionDTO()
                .withId(ID)
                .withDecision(DECISION)
                .withDate(DATE)
                .withUser(USER)
                .build();

        assertEquals(ID, decisionDTO.getId());
        assertEquals(DECISION, decisionDTO.getDecision());
        assertEquals(DATE, decisionDTO.getDate());
        assertEquals(USER, decisionDTO.getUser());
    }
}