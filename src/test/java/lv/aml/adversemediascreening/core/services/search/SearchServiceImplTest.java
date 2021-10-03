package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.dao.SearchDAO;
import lv.aml.adversemediascreening.core.domain.Search;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearchServiceImplTest {

    private SearchService searchService;

    @Mock
    private SearchDAO searchDAO;

    @BeforeEach
    public void setUp(){
        searchService = new SearchServiceImpl(searchDAO);
    }

    @Test
    public void getByIdShouldInvokeDAOTest(){
        Search search = new Search();
        when(searchDAO.findById(any())).then(invocationOnMock -> Optional.of(search));
        searchService.getById(any());
        verify(searchDAO).findById(any());
    }
}