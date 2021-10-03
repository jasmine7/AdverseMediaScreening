package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Search;
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
class SearchDAOTest extends DomainDAOTest {

    private final SearchDAO searchDAO;

    @Autowired
    public SearchDAOTest(SearchDAO searchDAO) {
        this.searchDAO = searchDAO;
    }

    @Test
    @Transactional
    public void createSearchTest(){
        Search search = createSearchForTest();
        assertNull(search.getId());
        searchDAO.save(search);
        assertNotNull(search.getId());
    }

    @Test
    @Transactional
    public void getSearchByIdTest(){
        Search search = createSearchForTest();
        assertNull(search.getId());
        searchDAO.save(search);
        assertNotNull(search.getId());
        Optional<Search> fromDB = searchDAO.findById(search.getId());

        assertEquals(search.getCreatedDate(), fromDB.get().getCreatedDate());
        assertEquals(search.getDateRestrict(), fromDB.get().getDateRestrict());
        assertEquals(search.getClient(), fromDB.get().getClient());
        assertEquals(search.getKeywords(), fromDB.get().getKeywords());
        assertEquals(search.getUser(), fromDB.get().getUser());
        assertEquals(search.getResults(), fromDB.get().getResults());
        assertEquals(search.getResultCount(), fromDB.get().getResultCount());
    }
}