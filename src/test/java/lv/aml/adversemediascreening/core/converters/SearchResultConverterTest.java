package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;
import static lv.aml.adversemediascreening.core.builders.result.SearchResultDTOBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class SearchResultConverterTest {

    private static final Long ID = 1L;
    private static final String TITLE = RandomStringUtils.randomAlphabetic(15);
    private static final String LINK = RandomStringUtils.randomAlphabetic(15);
    private static final String SNIPPET = RandomStringUtils.randomAlphabetic(15);
    private static final Search SEARCH = new Search();

    private final SearchResultConverter resultConverter;

    @Autowired
    public SearchResultConverterTest(SearchResultConverter resultConverter){
        this.resultConverter = resultConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        SearchResult result = createSearchResultForTest(ID, TITLE, LINK, SNIPPET, SEARCH);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        SearchResult result = createSearchResultForTest(null, TITLE, LINK, SNIPPET, SEARCH);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityConvertToDTOIfTitleIsNullTest(){
        SearchResult result = createSearchResultForTest(ID, null, LINK, SNIPPET, SEARCH);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityConvertToDTOIfLinkIsNullTest(){
        SearchResult result = createSearchResultForTest(ID, TITLE, null, SNIPPET, SEARCH);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityConvertToDTOIfSnippetIsNullTest(){
        SearchResult result = createSearchResultForTest(ID, TITLE, LINK, null, SEARCH);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityConvertToDTOIfSearchIsNullTest(){
        SearchResult result = createSearchResultForTest(ID, TITLE, LINK, SNIPPET, null);
        SearchResultDTO dto = resultConverter.convertToDTO(result);
        assertEquals(result.getId(), dto.getId());
        assertEquals(result.getTitle(), dto.getTitle());
        assertEquals(result.getLink(), dto.getLink());
        assertEquals(result.getSnippet(), dto.getSnippet());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        List<SearchResult> results = new ArrayList<>();
        results.add(createSearchResultForTest(ID, TITLE, LINK, SNIPPET, SEARCH));
        List<SearchResultDTO> dtos = resultConverter.convertToDTO(results);
        assertEquals(results.get(0).getId(), dtos.get(0).getId());
        assertEquals(results.get(0).getTitle(), dtos.get(0).getTitle());
        assertEquals(results.get(0).getLink(), dtos.get(0).getLink());
        assertEquals(results.get(0).getSnippet(), dtos.get(0).getSnippet());
    }

    @Test
    public void dtoConvertToEntityTest(){
        SearchResultDTO dto = createDTOForTest(ID, TITLE, LINK, SNIPPET);
        SearchResult result = resultConverter.convertToEntity(dto);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getLink(), result.getLink());
        assertEquals(dto.getSnippet(), result.getSnippet());
        assertNull(result.getSearch());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        SearchResultDTO dto = createDTOForTest(null, TITLE, LINK, SNIPPET);
        SearchResult result = resultConverter.convertToEntity(dto);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getLink(), result.getLink());
        assertEquals(dto.getSnippet(), result.getSnippet());
        assertNull(result.getSearch());
    }

    @Test
    public void dtoConvertToEntityIfTitleIsNullTest(){
        SearchResultDTO dto = createDTOForTest(ID, null, LINK, SNIPPET);
        SearchResult result = resultConverter.convertToEntity(dto);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getLink(), result.getLink());
        assertEquals(dto.getSnippet(), result.getSnippet());
        assertNull(result.getSearch());
    }

    @Test
    public void dtoConvertToEntityIfLinkIsNullTest(){
        SearchResultDTO dto = createDTOForTest(ID, TITLE, null, SNIPPET);
        SearchResult result = resultConverter.convertToEntity(dto);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getLink(), result.getLink());
        assertEquals(dto.getSnippet(), result.getSnippet());
        assertNull(result.getSearch());
    }

    @Test
    public void dtoConvertToEntityIfSnippetIsNullTest(){
        SearchResultDTO dto = createDTOForTest(ID, TITLE, LINK, null);
        SearchResult result = resultConverter.convertToEntity(dto);
        assertEquals(dto.getId(), result.getId());
        assertEquals(dto.getTitle(), result.getTitle());
        assertEquals(dto.getLink(), result.getLink());
        assertEquals(dto.getSnippet(), result.getSnippet());
        assertNull(result.getSearch());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        List<SearchResultDTO> dtos = new ArrayList<>();
        dtos.add(createDTOForTest(ID, TITLE, LINK, SNIPPET));
        List<SearchResult> results = resultConverter.convertToEntity(dtos);
        assertEquals(dtos.get(0).getId(), results.get(0).getId());
        assertEquals(dtos.get(0).getTitle(), results.get(0).getTitle());
        assertEquals(dtos.get(0).getLink(), results.get(0).getLink());
        assertEquals(dtos.get(0).getSnippet(), results.get(0).getSnippet());
        assertNull(results.get(0).getSearch());
    }

    private SearchResult createSearchResultForTest(Long id,
                                                   String title,
                                                   String link,
                                                   String snippet,
                                                   Search search){
        return createSearchResult()
                .withId(id)
                .withTitle(title)
                .withLink(link)
                .withSnippet(snippet)
                .withSearch(search)
                .build();
    }

    private SearchResultDTO createDTOForTest(Long id,
                                             String title,
                                             String link,
                                             String snippet){
        return createSearchResultDTO()
                .withId(id)
                .withTitle(title)
                .withLink(link)
                .withSnippet(snippet)
                .build();
    }
}