package lv.aml.adversemediascreening.core.services.decision;

import lv.aml.adversemediascreening.core.dao.ResultDecisionDAO;
import lv.aml.adversemediascreening.core.domain.ResultDecision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultDecisionServiceImpl implements ResultDecisionService {

    private final ResultDecisionDAO resultDecisionDAO;

    @Autowired
    public ResultDecisionServiceImpl(ResultDecisionDAO resultDecisionDAO) {
        this.resultDecisionDAO = resultDecisionDAO;
    }

    @Override
    public List<ResultDecision> getAllByResultId(Long resultId) {
        return resultDecisionDAO.findByResultIdAndFetchUserEagerly(resultId);
    }
}
