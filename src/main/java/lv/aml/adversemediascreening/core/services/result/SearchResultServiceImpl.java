package lv.aml.adversemediascreening.core.services.result;

import lv.aml.adversemediascreening.core.builders.result.SearchResultDTOBuilder;
import lv.aml.adversemediascreening.core.dao.SearchResultDAO;
import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import lv.aml.adversemediascreening.core.exceptions.SearchResultNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.result.SearchResultDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserDTOBuilder.*;

@Service
public class SearchResultServiceImpl implements SearchResultService {

    private final SearchResultDAO searchResultDAO;

    @Autowired
    public SearchResultServiceImpl(SearchResultDAO searchResultDAO) {
        this.searchResultDAO = searchResultDAO;
    }

//    @Override
//    public List<SearchResultDTO> getAllBySearchId(Long id) {
//        return searchResultDAO.getAllResultsBySearchId(id);
//    }

    @Override
    public List<SearchResultDTO> getAllBySearchId(Long id) {
        List<Tuple> searchResultTuple = searchResultDAO.getAllResultsWithDecisionsBySearchId(id);
        List<SearchResultDTO> searchResultDTOs = new ArrayList<>();
        if(!searchResultTuple.isEmpty()){
            for(Tuple t: searchResultTuple){
                SearchResultDTOBuilder resultBuilder = createSearchResultDTO()
                        .withId(t.get(0, BigInteger.class).longValue())
                        .withTitle(t.get(2, String.class))
                        .withLink(t.get(3, String.class))
                        .withSnippet(t.get(4, String.class));
                if(t.get(5) != null){
                    resultBuilder.withDecision(
                            createResultDecisionDTO()
                                    .withId(t.get(5, BigInteger.class).longValue())
                                    .withDecision(t.get(7, Boolean.class))
                                    .withDate(ZonedDateTime.ofInstant(
                                            t.get(8, Timestamp.class).toInstant(), ZoneId.of("UTC")
                                    ))
                                    .withUser(
                                            createUserDTO()
                                                    .withId(t.get(9, BigInteger.class).longValue())
                                                    .withUsername(t.get(10, String.class))
                                                    .withFirstName(t.get(11, String.class))
                                                    .withLastName(t.get(12, String.class))
                                                    .build()
                                    )
                                    .build()
                    );
                } else {
                    resultBuilder.withDecision(null);
                }
                searchResultDTOs.add(resultBuilder.build());
            }
        }
        return searchResultDTOs;
    }

    @Override
    public SearchResult getById(Long id) {
        return searchResultDAO.findById(id).orElseThrow(()-> new SearchResultNotFoundException(id));
    }
}
