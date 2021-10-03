package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import lv.aml.adversemediascreening.core.domain.Keyword;

import java.util.List;

public interface SearchValidator {

    void validateForCreate(DateRestrict dateRestrict,
                           Client client,
                           List<Keyword> keywords);
}
