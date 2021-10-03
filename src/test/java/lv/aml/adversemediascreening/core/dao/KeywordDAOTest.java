package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
class KeywordDAOTest extends DomainDAOTest {

    private final KeywordDAO keywordDAO;

    @Autowired
    public KeywordDAOTest(KeywordDAO keywordDAO) {
        this.keywordDAO = keywordDAO;
    }

    @Test
    @Transactional
    public void createKeywordTest(){
        Keyword keyword = createKeywordForTest();
        assertNull(keyword.getId());
        keywordDAO.save(keyword);
        assertNotNull(keyword.getId());
    }

    @Test
    @Transactional
    public void getKeywordByIdTest(){
        Keyword keyword = createKeywordForTest();
        assertNull(keyword.getId());
        keywordDAO.save(keyword);
        assertNotNull(keyword.getId());
        Optional<Keyword> fromDB = keywordDAO.findById(keyword.getId());
        assertEquals(keyword.getId(), fromDB.get().getId());
        assertEquals(keyword.getName(), fromDB.get().getName());
    }

    @Test
    @Transactional
    public void getAllKeywordDTOsTest(){
        List<KeywordDTO> dtos = keywordDAO.getAllKeywordDTOs();
        Boolean checkSize = dtos.size() >= 1;
        assertEquals(true, checkSize);
    }
}