package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.domain.Search;

import java.util.List;

public interface SearchFactory {

    Search create(User user,
                  DateRestrict dateRestrict,
                  Client client,
                  List<Keyword> keywords);
}
