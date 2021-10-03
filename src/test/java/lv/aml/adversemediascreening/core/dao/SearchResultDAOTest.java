package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
class SearchResultDAOTest extends DomainDAOTest {

    private final SearchResultDAO resultDAO;

    @Autowired
    public SearchResultDAOTest(SearchResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

    @Test
    @Transactional
    public void createResultTest(){
        SearchResult result = createResultForTest();
        assertNull(result.getId());
        resultDAO.save(result);
        assertNotNull(result.getId());
    }

    @Test
    @Transactional
    public void getResultByIdTest(){
        SearchResult result = createResultForTest();
        assertNull(result.getId());
        resultDAO.save(result);
        assertNotNull(result.getId());
        Optional<SearchResult> fromDB = resultDAO.findById(result.getId());

        assertEquals(result.getSearch(), fromDB.get().getSearch());
        assertEquals(result.getTitle(), fromDB.get().getTitle());
        assertEquals(result.getLink(), fromDB.get().getLink());
        assertEquals(result.getSnippet(), fromDB.get().getSnippet());
    }
}