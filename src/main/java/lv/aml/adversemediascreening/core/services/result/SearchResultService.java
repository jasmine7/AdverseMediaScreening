package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;

import java.util.List;

public interface SearchResultService {

    List<SearchResultDTO> getAllBySearchId(Long id);

    SearchResult getById(Long id);

}
