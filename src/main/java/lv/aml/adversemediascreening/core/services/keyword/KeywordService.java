package lv.aml.adversemediascreening.core.services.keyword;

import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;

import java.util.List;

public interface KeywordService {

    Keyword getById(Long id);

    List<KeywordDTO> getAll();
}
