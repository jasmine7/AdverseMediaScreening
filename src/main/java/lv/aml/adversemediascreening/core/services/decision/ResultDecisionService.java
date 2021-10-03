package lv.aml.adversemediascreening.core.services.decision;

import lv.aml.adversemediascreening.core.domain.ResultDecision;

import java.util.List;

public interface ResultDecisionService {

    List<ResultDecision> getAllByResultId(Long resultId);
}
