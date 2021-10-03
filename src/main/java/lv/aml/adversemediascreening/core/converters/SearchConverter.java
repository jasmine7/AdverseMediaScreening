package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.dto.SearchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.search.SearchBuilder.*;
import static lv.aml.adversemediascreening.core.builders.search.SearchDTOBuilder.*;

@Component
public class SearchConverter {

    private final UserConverter userConverter;
    private final ClientConverter clientConverter;
    private final KeywordConverter keywordConverter;
    private final SearchResultConverter resultConverter;

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchConverter.class);

    @Autowired
    public SearchConverter(UserConverter userConverter,
                           ClientConverter clientConverter,
                           KeywordConverter keywordConverter,
                           SearchResultConverter resultConverter){
        this.userConverter = userConverter;
        this.clientConverter = clientConverter;
        this.keywordConverter = keywordConverter;
        this.resultConverter = resultConverter;
    }

    public Search convertToEntity(SearchDTO searchDTO){
        if(searchDTO == null){
            return null;
        } else {
            return createSearch()
                    .withId(searchDTO.getId())
                    .withCreatedDate(searchDTO.getCreatedDate())
                    .withUser(userConverter.convertToEntity(searchDTO.getUser()))
                    .withDateRestrict(searchDTO.getDateRestrict())
                    .withClient(clientConverter.convertToEntity(searchDTO.getClient()))
                    .withKeywords(keywordConverter.convertToEntity(searchDTO.getKeywords()))
                    .withSearchResults(new ArrayList<>())
                    .withResultCount(searchDTO.getResultCount())
                    .build();
        }
    }

    public SearchDTO convertToDTO(Search search){
        if(search == null){
            return null;
        } else {
            return createSearchDTO()
                    .withId(search.getId())
                    .withCreatedDate(search.getCreatedDate())
                    .withUser(userConverter.convertToDTO(search.getUser()))
                    .withDateRestrict(search.getDateRestrict())
                    .withClient(clientConverter.convertToDTO(search.getClient()))
                    .withKeywords(keywordConverter.convertToDTO(search.getKeywords()))
                    .withResultCount(search.getResultCount())
                    .build();
        }
    }

    public List<Search> convertToEntity(List<SearchDTO> searchDTOs){
        if(searchDTOs != null){
            List<Search> searches = new ArrayList<>();
            if(!searchDTOs.isEmpty()){
                for(SearchDTO searchDTO: searchDTOs){
                    searches.add(convertToEntity(searchDTO));
                }
            }
            return searches;
        }
        return null;
    }

    public List<SearchDTO> convertToDTO(List<Search> searches){
        if(searches != null){
            List<SearchDTO> searchDTOs = new ArrayList<>();
            if(!searches.isEmpty()){
                for(Search search: searches){
                    searchDTOs.add(convertToDTO(search));
                }
            }
            return searchDTOs;
        }
        return null;
    }


}
