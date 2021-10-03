package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.*;
import lv.aml.adversemediascreening.core.dto.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static lv.aml.adversemediascreening.core.builders.search.SearchBuilder.*;
import static lv.aml.adversemediascreening.core.builders.search.SearchDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;
import static lv.aml.adversemediascreening.core.builders.client.ClientDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordBuilder.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserDTOBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class SearchConverterTest {

    private static final Long ID = 1L;
    private static final ZonedDateTime CREATED_DATE = ZonedDateTime.now();
    private final User USER = createUserForTest();
    private final UserDTO USER_DTO = createUserDTOForTest();
    private static final DateRestrict DATE_RESTRICT = DateRestrict.YEAR;
    private final Client CLIENT = createClientToTest();
    private final ClientDTO CLIENT_DTO = createClientDTOToTest();
    private final List<Keyword> KEYWORDS = createKeywordListForTest();
    private final List<KeywordDTO> KEYWORD_DTOS = createKeywordDTOListForTest();
    private final List<SearchResult> RESULTS = createSearchResultListForTest();
    private static final Integer RESULT_COUNT = 15;

    private final SearchConverter searchConverter;

    @Autowired
    public SearchConverterTest(SearchConverter searchConverter){
        this.searchConverter = searchConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        Search search = createSearchForTest(null,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfCreatedDateIsNullTest(){
        Search search = createSearchForTest(ID,
                null,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfUserIsNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                null,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertNull(search.getUser());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfDateRestrictIsNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                null,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfClientIsNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                null,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertNull(dto.getClient());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfKeywordsAreNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                null,
                RESULTS,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertNull(dto.getKeywords());
    }

    @Test
    public void entityConvertToDTOIfResultsAreNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                null,
                RESULT_COUNT
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertEquals(search.getResultCount(), dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityConvertToDTOIfResultCountIsNullTest(){
        Search search = createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                null
        );
        SearchDTO dto = searchConverter.convertToDTO(search);

        assertEquals(search.getId(), dto.getId());
        assertEquals(search.getCreatedDate(), dto.getCreatedDate());
        assertEquals(search.getDateRestrict(), dto.getDateRestrict());
        assertNull(dto.getResultCount());

        assertEquals(search.getUser().getId(), dto.getUser().getId());
        assertEquals(search.getUser().getUsername(), dto.getUser().getUsername());
        assertEquals(search.getUser().getFirstName(), dto.getUser().getFirstName());
        assertEquals(search.getUser().getLastName(), dto.getUser().getLastName());

        assertEquals(search.getClient().getId(), dto.getClient().getId());
        assertEquals(search.getClient().getName(), dto.getClient().getName());
        assertEquals(search.getClient().getType(), dto.getClient().getType());
        assertEquals(search.getClient().getRegistrationNumber(), dto.getClient().getRegistrationNumber());

        assertEquals(search.getKeywords().get(0).getId(), dto.getKeywords().get(0).getId());
        assertEquals(search.getKeywords().get(0).getName(), dto.getKeywords().get(0).getName());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        List<Search> searches = new ArrayList<>();
        searches.add(createSearchForTest(ID,
                CREATED_DATE,
                USER,
                DATE_RESTRICT,
                CLIENT,
                KEYWORDS,
                RESULTS,
                RESULT_COUNT)
        );
        List<SearchDTO> dtos = searchConverter.convertToDTO(searches);

        assertEquals(searches.get(0).getId(), dtos.get(0).getId());
        assertEquals(searches.get(0).getCreatedDate(), dtos.get(0).getCreatedDate());
        assertEquals(searches.get(0).getDateRestrict(), dtos.get(0).getDateRestrict());
        assertEquals(searches.get(0).getResultCount(), dtos.get(0).getResultCount());

        assertEquals(searches.get(0).getUser().getId(), dtos.get(0).getUser().getId());
        assertEquals(searches.get(0).getUser().getUsername(), dtos.get(0).getUser().getUsername());
        assertEquals(searches.get(0).getUser().getFirstName(), dtos.get(0).getUser().getFirstName());
        assertEquals(searches.get(0).getUser().getLastName(), dtos.get(0).getUser().getLastName());

        assertEquals(searches.get(0).getClient().getId(), dtos.get(0).getClient().getId());
        assertEquals(searches.get(0).getClient().getName(), dtos.get(0).getClient().getName());
        assertEquals(searches.get(0).getClient().getType(), dtos.get(0).getClient().getType());
        assertEquals(searches.get(0).getClient().getRegistrationNumber(), dtos.get(0).getClient().getRegistrationNumber());

        assertEquals(searches.get(0).getKeywords().get(0).getId(), dtos.get(0).getKeywords().get(0).getId());
        assertEquals(searches.get(0).getKeywords().get(0).getName(), dtos.get(0).getKeywords().get(0).getName());

    }

    @Test
    public void dtoConvertToEntityTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        SearchDTO dto = createDTOForTest(null,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfCreatedDateIsNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                null,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfUserIsNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                null,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertNull(dto.getUser());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfDateRestrictIsNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                null,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfClientIsNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                null,
                KEYWORD_DTOS,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertNull(search.getClient());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfKeywordsAreNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                null,
                RESULT_COUNT
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertNull(search.getKeywords());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoConvertToEntityIfResultCountIsNullTest(){
        SearchDTO dto = createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                null
        );
        Search search = searchConverter.convertToEntity(dto);

        assertEquals(dto.getId(), search.getId());
        assertEquals(dto.getCreatedDate(), search.getCreatedDate());
        assertEquals(dto.getDateRestrict(), search.getDateRestrict());
        assertEquals(dto.getResultCount(), search.getResultCount());

        assertEquals(dto.getUser().getId(), search.getUser().getId());
        assertEquals(dto.getUser().getUsername(), search.getUser().getUsername());
        assertEquals(dto.getUser().getFirstName(), search.getUser().getFirstName());
        assertEquals(dto.getUser().getLastName(), search.getUser().getLastName());

        assertEquals(dto.getClient().getId(), search.getClient().getId());
        assertEquals(dto.getClient().getName(), search.getClient().getName());
        assertEquals(dto.getClient().getType(), search.getClient().getType());
        assertEquals(dto.getClient().getRegistrationNumber(), search.getClient().getRegistrationNumber());

        assertEquals(dto.getKeywords().get(0).getId(), search.getKeywords().get(0).getId());
        assertEquals(dto.getKeywords().get(0).getName(), search.getKeywords().get(0).getName());

        assertEquals(0, search.getResults().size());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        List<SearchDTO> dtos = new ArrayList<>();
        dtos.add(createDTOForTest(ID,
                CREATED_DATE,
                USER_DTO,
                DATE_RESTRICT,
                CLIENT_DTO,
                KEYWORD_DTOS,
                RESULT_COUNT
        ));
        List<Search> searches = searchConverter.convertToEntity(dtos);

        assertEquals(dtos.get(0).getId(), searches.get(0).getId());
        assertEquals(dtos.get(0).getCreatedDate(), searches.get(0).getCreatedDate());
        assertEquals(dtos.get(0).getDateRestrict(), searches.get(0).getDateRestrict());
        assertEquals(dtos.get(0).getResultCount(), searches.get(0).getResultCount());

        assertEquals(dtos.get(0).getUser().getId(), searches.get(0).getUser().getId());
        assertEquals(dtos.get(0).getUser().getUsername(), searches.get(0).getUser().getUsername());
        assertEquals(dtos.get(0).getUser().getFirstName(), searches.get(0).getUser().getFirstName());
        assertEquals(dtos.get(0).getUser().getLastName(), searches.get(0).getUser().getLastName());

        assertEquals(dtos.get(0).getClient().getId(), searches.get(0).getClient().getId());
        assertEquals(dtos.get(0).getClient().getName(), searches.get(0).getClient().getName());
        assertEquals(dtos.get(0).getClient().getType(), searches.get(0).getClient().getType());
        assertEquals(dtos.get(0).getClient().getRegistrationNumber(), searches.get(0).getClient().getRegistrationNumber());

        assertEquals(dtos.get(0).getKeywords().get(0).getId(), searches.get(0).getKeywords().get(0).getId());
        assertEquals(dtos.get(0).getKeywords().get(0).getName(), searches.get(0).getKeywords().get(0).getName());

        assertEquals(0, searches.get(0).getResults().size());
    }

    private Search createSearchForTest(Long id,
                                       ZonedDateTime createdDate,
                                       User user,
                                       DateRestrict dateRestrict,
                                       Client client,
                                       List<Keyword> keywords,
                                       List<SearchResult> results,
                                       Integer resultCount){
        return createSearch()
                .withId(id)
                .withUser(user)
                .withCreatedDate(createdDate)
                .withDateRestrict(dateRestrict)
                .withClient(client)
                .withKeywords(keywords)
                .withSearchResults(results)
                .withResultCount(resultCount)
                .build();
    }

    private SearchDTO createDTOForTest(Long id,
                                       ZonedDateTime createdDate,
                                       UserDTO user,
                                       DateRestrict dateRestrict,
                                       ClientDTO client,
                                       List<KeywordDTO> keywords,
                                       Integer resultCount){
        return createSearchDTO()
                .withId(id)
                .withCreatedDate(createdDate)
                .withUser(user)
                .withDateRestrict(dateRestrict)
                .withClient(client)
                .withKeywords(keywords)
                .withResultCount(resultCount)
                .build();
    }

    private Client createClientToTest(){
        return createClient()
                .withId(1L)
                .withName(RandomStringUtils.randomAlphabetic(15))
                .withType(RandomStringUtils.randomAlphabetic(5))
                .withRegistrationNumber(RandomStringUtils.randomNumeric(10))
                .build();
    }

    private ClientDTO createClientDTOToTest(){
        return createClientDTO()
                .withId(1L)
                .withName(RandomStringUtils.randomAlphabetic(15))
                .withType(RandomStringUtils.randomAlphabetic(5))
                .withRegistrationNumber(RandomStringUtils.randomNumeric(10))
                .build();
    }

    private List<Keyword> createKeywordListForTest(){
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(
                createKeyword()
                        .withId(1L)
                        .withName(RandomStringUtils.randomAlphabetic(10))
                        .build()
        );
        return keywords;
    }

    private List<KeywordDTO> createKeywordDTOListForTest(){
        List<KeywordDTO> dtos = new ArrayList<>();
        dtos.add(
                createKeywordDTO()
                        .withId(1L)
                        .withName(RandomStringUtils.randomAlphabetic(10))
                        .build()
        );
        return dtos;
    }

    private List<SearchResult> createSearchResultListForTest(){
        List<SearchResult> results = new ArrayList<>();
        results.add(createSearchResult()
                .withId(1L)
                .withTitle(RandomStringUtils.randomAlphabetic(15))
                .withLink(RandomStringUtils.randomAlphabetic(15))
                .withSnippet(RandomStringUtils.randomAlphabetic(15))
                .build()
        );
        return results;
    }

    private User createUserForTest(){
        return createUser()
                .withId(1L)
                .withUsername(RandomStringUtils.randomAlphabetic(15))
                .withPassword(RandomStringUtils.randomAlphabetic(15))
                .withFirstName(RandomStringUtils.randomAlphabetic(15))
                .withLastName(RandomStringUtils.randomAlphabetic(15))
                .build();
    }

    private UserDTO createUserDTOForTest(){
        return createUserDTO()
                .withId(1L)
                .withUsername(RandomStringUtils.randomAlphabetic(15))
                .withFirstName(RandomStringUtils.randomAlphabetic(15))
                .withLastName(RandomStringUtils.randomAlphabetic(15))
                .build();
    }
}