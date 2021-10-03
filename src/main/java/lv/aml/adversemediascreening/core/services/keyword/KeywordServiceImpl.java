package lv.aml.adversemediascreening.core.services.keyword;

import lv.aml.adversemediascreening.core.dao.KeywordDAO;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import lv.aml.adversemediascreening.core.exceptions.KeywordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    private final KeywordDAO keywordDAO;

    @Autowired
    public KeywordServiceImpl(KeywordDAO keywordDAO){
        this.keywordDAO = keywordDAO;
    }

    @Override
    public Keyword getById(Long id) {
        return keywordDAO.findById(id).orElseThrow(()-> new KeywordNotFoundException(id));
    }

    @Override
    public List<KeywordDTO> getAll() {
        return keywordDAO.getAllKeywordDTOs();
    }
}
