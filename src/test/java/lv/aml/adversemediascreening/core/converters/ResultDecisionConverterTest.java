package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.ResultDecisionDTO;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionBuilder.*;
import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionDTOBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class ResultDecisionConverterTest {

    private static final Long ID = 1L;
    private static final SearchResult RESULT = new SearchResult();
    private static final Boolean DECISION = Boolean.TRUE;
    private static final ZonedDateTime DATE = ZonedDateTime.now();
    private static final User USER = new User();
    private static final UserDTO USER_DTO = new UserDTO();

    private final ResultDecisionConverter decisionConverter;

    @Autowired
    public ResultDecisionConverterTest(ResultDecisionConverter decisionConverter) {
        this.decisionConverter = decisionConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        ResultDecision decision = createDecisionForTest(ID, RESULT, DECISION, DATE, USER);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertEquals(decision.getUser().getId(), dto.getUser().getId());
        assertEquals(decision.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(decision.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(decision.getUser().getLastName(), dto.getUser().getLastName());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        ResultDecision decision = createDecisionForTest(null, RESULT, DECISION, DATE, USER);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertEquals(decision.getUser().getId(), dto.getUser().getId());
        assertEquals(decision.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(decision.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(decision.getUser().getLastName(), dto.getUser().getLastName());
    }

    @Test
    public void entityConvertToDTOIfResultIsNullTest(){
        ResultDecision decision = createDecisionForTest(ID, null, DECISION, DATE, USER);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertEquals(decision.getUser().getId(), dto.getUser().getId());
        assertEquals(decision.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(decision.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(decision.getUser().getLastName(), dto.getUser().getLastName());
    }

    @Test
    public void entityConvertToDTOIfDecisionIsNullTest(){
        ResultDecision decision = createDecisionForTest(ID, RESULT, null, DATE, USER);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertEquals(decision.getUser().getId(), dto.getUser().getId());
        assertEquals(decision.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(decision.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(decision.getUser().getLastName(), dto.getUser().getLastName());
    }

    @Test
    public void entityConvertToDTOIfDateIsNullTest(){
        ResultDecision decision = createDecisionForTest(ID, RESULT, DECISION, null, USER);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertEquals(decision.getUser().getId(), dto.getUser().getId());
        assertEquals(decision.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(decision.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(decision.getUser().getLastName(), dto.getUser().getLastName());
    }

    @Test
    public void entityConvertToDTOIfUserIsNullTest(){
        ResultDecision decision = createDecisionForTest(ID, RESULT, DECISION, DATE, null);
        ResultDecisionDTO dto = decisionConverter.convertToDTO(decision);

        assertEquals(decision.getId(), dto.getId());
        assertEquals(decision.getDecision(), dto.getDecision());
        assertEquals(decision.getDate(), dto.getDate());

        assertNull(dto.getUser());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        ResultDecision decision = createDecisionForTest(ID, RESULT, DECISION, DATE, USER);
        List<ResultDecision> decisions = new ArrayList<>();
        decisions.add(decision);
        List<ResultDecisionDTO> dtos = decisionConverter.convertToDTO(decisions);

        assertEquals(decisions.get(0).getId(), dtos.get(0).getId());
        assertEquals(decisions.get(0).getDecision(), dtos.get(0).getDecision());
        assertEquals(decisions.get(0).getDate(), dtos.get(0).getDate());

        assertEquals(decisions.get(0).getUser().getId(), dtos.get(0).getUser().getId());
        assertEquals(decisions.get(0).getUser().getUsername(), dtos.get(0).getUser().getUsername());
        assertEquals(decisions.get(0).getUser().getFirstName(), dtos.get(0).getUser().getFirstName());
        assertEquals(decisions.get(0).getUser().getLastName(), dtos.get(0).getUser().getLastName());
    }

    @Test
    public void dtoConvertToEntityTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(ID, DECISION, DATE, USER_DTO);
        ResultDecision decision = decisionConverter.convertToEntity(dto);

        assertEquals(dto.getId(), decision.getId());
        assertEquals(dto.getDecision(), decision.getDecision());
        assertEquals(dto.getDate(), decision.getDate());

        assertEquals(dto.getUser().getId(), decision.getUser().getId());
        assertEquals(dto.getUser().getUsername(), decision.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), decision.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), decision.getUser().getLastName());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(null, DECISION, DATE, USER_DTO);
        ResultDecision decision = decisionConverter.convertToEntity(dto);

        assertEquals(dto.getId(), decision.getId());
        assertEquals(dto.getDecision(), decision.getDecision());
        assertEquals(dto.getDate(), decision.getDate());

        assertEquals(dto.getUser().getId(), decision.getUser().getId());
        assertEquals(dto.getUser().getUsername(), decision.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), decision.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), decision.getUser().getLastName());
    }

    @Test
    public void dtoConvertToEntityIfDecisionIsNullTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(ID, null, DATE, USER_DTO);
        ResultDecision decision = decisionConverter.convertToEntity(dto);

        assertEquals(dto.getId(), decision.getId());
        assertEquals(dto.getDecision(), decision.getDecision());
        assertEquals(dto.getDate(), decision.getDate());

        assertEquals(dto.getUser().getId(), decision.getUser().getId());
        assertEquals(dto.getUser().getUsername(), decision.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), decision.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), decision.getUser().getLastName());
    }

    @Test
    public void dtoConvertToEntityIfDateIsNullTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(ID, DECISION, null, USER_DTO);
        ResultDecision decision = decisionConverter.convertToEntity(dto);

        assertEquals(dto.getId(), decision.getId());
        assertEquals(dto.getDecision(), decision.getDecision());
        assertEquals(dto.getDate(), decision.getDate());

        assertEquals(dto.getUser().getId(), decision.getUser().getId());
        assertEquals(dto.getUser().getUsername(), decision.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), decision.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), decision.getUser().getLastName());
    }

    @Test
    public void dtoConvertToEntityIfUserIsNullTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(ID, DECISION, DATE, null);
        ResultDecision decision = decisionConverter.convertToEntity(dto);

        assertEquals(dto.getId(), decision.getId());
        assertEquals(dto.getDecision(), decision.getDecision());
        assertEquals(dto.getDate(), decision.getDate());

        assertNull(decision.getUser());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        ResultDecisionDTO dto = createDecisionDTOForTest(ID, DECISION, DATE, USER_DTO);
        List<ResultDecisionDTO> dtos = new ArrayList<>();
        dtos.add(dto);
        List<ResultDecision> decisions = decisionConverter.convertToEntity(dtos);

        assertEquals(dtos.get(0).getId(), decisions.get(0).getId());
        assertEquals(dtos.get(0).getDecision(), decisions.get(0).getDecision());
        assertEquals(dtos.get(0).getDate(), decisions.get(0).getDate());

        assertEquals(dtos.get(0).getUser().getId(), decisions.get(0).getUser().getId());
        assertEquals(dtos.get(0).getUser().getUsername(), decisions.get(0).getUser().getUsername());
        assertEquals(dtos.get(0).getUser().getFirstName(), decisions.get(0).getUser().getFirstName());
        assertEquals(dtos.get(0).getUser().getLastName(), decisions.get(0).getUser().getLastName());
    }

    private ResultDecision createDecisionForTest(Long id,
                                                 SearchResult result,
                                                 Boolean decision,
                                                 ZonedDateTime date,
                                                 User user){
        return createResultDecision()
                .withId(id)
                .withResult(result)
                .withDecision(decision)
                .withDate(date)
                .withUser(user)
                .build();
    }

    private ResultDecisionDTO createDecisionDTOForTest(Long id,
                                                       Boolean decision,
                                                       ZonedDateTime date,
                                                       UserDTO user){
        return createResultDecisionDTO()
                .withId(id)
                .withDecision(decision)
                .withDate(date)
                .withUser(user)
                .build();
    }
}