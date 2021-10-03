package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
class ResultDecisionDAOTest extends DomainDAOTest {

    private final ResultDecisionDAO decisionDAO;

    @Autowired
    public ResultDecisionDAOTest(ResultDecisionDAO decisionDAO) {
        this.decisionDAO = decisionDAO;
    }

    @Test
    @Transactional
    public void createDecisionTest(){
        ResultDecision decision = createDecisionForTest();
        assertNull(decision.getId());
        decisionDAO.save(decision);
        assertNotNull(decision.getId());
    }

    @Test
    @Transactional
    public void getDecisionByIdTest(){
        ResultDecision decision = createDecisionForTest();
        assertNull(decision.getId());
        decisionDAO.save(decision);
        assertNotNull(decision.getId());
        Optional<ResultDecision> fromDB = decisionDAO.findById(decision.getId());

        assertEquals(decision.getResult(), fromDB.get().getResult());
        assertEquals(decision.getDecision(), fromDB.get().getDecision());
        assertEquals(decision.getDate(), fromDB.get().getDate());
        assertEquals(decision.getUser(), fromDB.get().getUser());
    }
}