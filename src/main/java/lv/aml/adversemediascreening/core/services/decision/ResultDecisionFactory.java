package lv.aml.adversemediascreening.core.services.decision;

import lv.aml.adversemediascreening.core.domain.ResultDecision;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.domain.User;

import java.time.ZonedDateTime;

public interface ResultDecisionFactory {

    ResultDecision create(SearchResult searchResult,
                          Boolean decision,
                          ZonedDateTime date,
                          User user);
}
