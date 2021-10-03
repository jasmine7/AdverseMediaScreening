package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;
import static lv.aml.adversemediascreening.core.builders.result.SearchResultDTOBuilder.*;

@Component
public class SearchResultConverter {

    public SearchResult convertToEntity(SearchResultDTO searchResultDTO){
        if(searchResultDTO == null){
            return null;
        } else {
            return createSearchResult()
                    .withId(searchResultDTO.getId())
                    .withTitle(searchResultDTO.getTitle())
                    .withLink(searchResultDTO.getLink())
                    .withSnippet(searchResultDTO.getSnippet())
                    .build();
        }
    }

    public SearchResultDTO convertToDTO(SearchResult searchResult){
        if(searchResult == null){
            return null;
        } else {
            return createSearchResultDTO()
                    .withId(searchResult.getId())
                    .withTitle(searchResult.getTitle())
                    .withLink(searchResult.getLink())
                    .withSnippet(searchResult.getSnippet())
                    .build();
        }
    }

    public List<SearchResult> convertToEntity(List<SearchResultDTO> searchResultDTOs){
        if(searchResultDTOs != null){
            List<SearchResult> searchResults = new ArrayList<>();
            if(!searchResultDTOs.isEmpty()){
                for(SearchResultDTO searchResultDTO: searchResultDTOs){
                    searchResults.add(convertToEntity(searchResultDTO));
                }
            }
            return searchResults;
        }
        return null;
    }

    public List<SearchResultDTO> convertToDTO(List<SearchResult> searchResults){
        if(searchResults != null){
            List<SearchResultDTO> searchResultDTOs = new ArrayList<>();
            if(!searchResults.isEmpty()){
                for (SearchResult searchResult: searchResults){
                    searchResultDTOs.add(convertToDTO(searchResult));
                }
            }
            return searchResultDTOs;
        }
        return null;
    }
}
