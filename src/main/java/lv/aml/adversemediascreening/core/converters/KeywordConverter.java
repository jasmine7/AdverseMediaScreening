package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.keyword.KeywordBuilder.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordDTOBuilder.*;

@Component
public class KeywordConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeywordConverter.class);

    public Keyword convertToEntity(KeywordDTO keywordDTO){
        if(keywordDTO == null){
            return null;
        } else {
            return createKeyword()
                    .withId(keywordDTO.getId())
                    .withName(keywordDTO.getName())
                    .build();
        }
    }
    
    public KeywordDTO convertToDTO(Keyword keyword){
        if(keyword == null){
            return null;
        } else {
            return createKeywordDTO()
                    .withId(keyword.getId())
                    .withName(keyword.getName())
                    .build();
        }
    }

    public List<Keyword> convertToEntity(List<KeywordDTO> keywordDTOs){
        if(keywordDTOs != null){
            List<Keyword> keywords = new ArrayList<>();
            if(!keywordDTOs.isEmpty()){
                for(KeywordDTO keywordDTO: keywordDTOs){
                    keywords.add(convertToEntity(keywordDTO));
                }
            }
            return keywords;
        }
        return null;
    }

    public List<KeywordDTO> convertToDTO(List<Keyword> keywords){
        if(keywords != null){
            List<KeywordDTO> keywordDTOs = new ArrayList<>();
            if(!keywords.isEmpty()){
                for(Keyword keyword: keywords){
                    keywordDTOs.add(convertToDTO(keyword));
                }
            }
            return keywordDTOs;
        }
        return null;
    }
}
