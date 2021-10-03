package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.config.AppCoreConfig;
import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
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

import static lv.aml.adversemediascreening.core.builders.keyword.KeywordBuilder.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordDTOBuilder.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AppCoreConfig.class)
@Component
class KeywordConverterTest {

    private static final Long ID = 1L;
    private static final String NAME = RandomStringUtils.randomAlphabetic(10);

    private final KeywordConverter keywordConverter;

    @Autowired
    public KeywordConverterTest(KeywordConverter keywordConverter){
        this.keywordConverter = keywordConverter;
    }

    @Test
    public void entityConvertToDTOTest(){
        Keyword keyword = createKeywordForTest(ID, NAME);
        KeywordDTO dto = keywordConverter.convertToDTO(keyword);
        assertEquals(keyword.getId(), dto.getId());
        assertEquals(keyword.getName(), dto.getName());
    }

    @Test
    public void entityConvertToDTOIfIdIsNullTest(){
        Keyword keyword = createKeywordForTest(null, NAME);
        KeywordDTO dto = keywordConverter.convertToDTO(keyword);
        assertEquals(keyword.getId(), dto.getId());
        assertEquals(keyword.getName(), dto.getName());
    }

    @Test
    public void entityConvertToDTOIfNameIsNullTest(){
        Keyword keyword = createKeywordForTest(ID, null);
        KeywordDTO dto = keywordConverter.convertToDTO(keyword);
        assertEquals(keyword.getId(), dto.getId());
        assertEquals(keyword.getName(), dto.getName());
    }

    @Test
    public void entityListConvertToDTOListTest(){
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(createKeywordForTest(ID, NAME));
        List<KeywordDTO> dtos = keywordConverter.convertToDTO(keywords);
        assertEquals(keywords.get(0).getId(), dtos.get(0).getId());
        assertEquals(keywords.get(0).getName(), dtos.get(0).getName());
    }

    @Test
    public void dtoConvertToEntityTest(){
        KeywordDTO dto = createDTOForTest(ID, NAME);
        Keyword keyword = keywordConverter.convertToEntity(dto);
        assertEquals(dto.getId(), keyword.getId());
        assertEquals(dto.getName(), keyword.getName());
    }

    @Test
    public void dtoConvertToEntityIfIdIsNullTest(){
        KeywordDTO dto = createDTOForTest(null, NAME);
        Keyword keyword = keywordConverter.convertToEntity(dto);
        assertEquals(dto.getId(), keyword.getId());
        assertEquals(dto.getName(), keyword.getName());
    }

    @Test
    public void dtoConvertToEntityIfNameIsNullTest(){
        KeywordDTO dto = createDTOForTest(ID, null);
        Keyword keyword = keywordConverter.convertToEntity(dto);
        assertEquals(dto.getId(), keyword.getId());
        assertEquals(dto.getName(), keyword.getName());
    }

    @Test
    public void dtoListConvertToEntityListTest(){
        List<KeywordDTO> dtos = new ArrayList<>();
        dtos.add(createDTOForTest(ID, NAME));
        List<Keyword> keywords = keywordConverter.convertToEntity(dtos);
        assertEquals(dtos.get(0).getId(), keywords.get(0).getId());
        assertEquals(dtos.get(0).getName(), keywords.get(0).getName());
    }

    private Keyword createKeywordForTest(Long id, String name){
        return createKeyword().withId(id).withName(name).build();
    }

    private KeywordDTO createDTOForTest(Long id, String name){
        return createKeywordDTO().withId(id).withName(name).build();
    }
}