package lv.aml.adversemediascreening.core.services.decision;

import lv.aml.adversemediascreening.core.dao.ResultDecisionDAO;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionBuilder.*;

@Service
public class ResultDecisionFactoryImpl implements ResultDecisionFactory {

    private final ResultDecisionDAO resultDecisionDAO;

    @Autowired
    public ResultDecisionFactoryImpl(ResultDecisionDAO resultDecisionDAO) {
        this.resultDecisionDAO = resultDecisionDAO;
    }

    @Override
    public ResultDecision create(SearchResult searchResult, Boolean decision, ZonedDateTime date, User user) {
        ResultDecision resultDecision = createResultDecision()
                .withResult(searchResult)
                .withDecision(decision)
                .withDate(date)
                .withUser(user)
                .build();
        resultDecisionDAO.save(resultDecision);
        return resultDecision;
    }
}
