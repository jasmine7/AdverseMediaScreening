package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.*;
import lv.aml.adversemediascreening.searchengine.DateRestrict;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;
import static lv.aml.adversemediascreening.core.builders.keyword.KeywordBuilder.*;
import static lv.aml.adversemediascreening.core.builders.search.SearchBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;
import static lv.aml.adversemediascreening.core.builders.result.SearchResultBuilder.*;
import static lv.aml.adversemediascreening.core.builders.decision.ResultDecisionBuilder.*;

public class DomainDAOTest {

    public Client createClientForTest(){
        return createClient()
                .withName(RandomStringUtils.randomAlphabetic(10))
                .withType(RandomStringUtils.randomAlphabetic(3))
                .withRegistrationNumber(RandomStringUtils.randomNumeric(8))
                .withCountry(RandomStringUtils.randomAlphabetic(2))
                .build();
    }

    public Keyword createKeywordForTest(){
        return createKeyword().withName(RandomStringUtils.randomAlphabetic(12)).build();
    }

    public Search createSearchForTest(){
        List<Keyword> keywords = new ArrayList<>();
        keywords.add(createKeywordForTest());

        List<SearchResult> results = new ArrayList<>();
        results.add(createResultForTest());

        return createSearch()
                .withClient(createClientForTest())
                .withCreatedDate(ZonedDateTime.now())
                .withDateRestrict(DateRestrict.ALL_TIME)
                .withUser(createUserForTest())
                .withKeywords(keywords)
                .withSearchResults(results)
                .build();
    }

    public User createUserForTest(){
        return createUser()
                .withUsername(RandomStringUtils.randomAlphabetic(10))
                .withFirstName(RandomStringUtils.randomAlphabetic(10))
                .withLastName(RandomStringUtils.randomAlphabetic(10))
                .withPassword(RandomStringUtils.randomAlphabetic(10))
                .build();
    }

    public SearchResult createResultForTest(){
        return createSearchResult()
                .withTitle(RandomStringUtils.randomAlphabetic(15))
                .withLink(RandomStringUtils.randomAlphabetic(15))
                .withSnippet(RandomStringUtils.randomAlphabetic(15))
                .build();
    }

    public ResultDecision createDecisionForTest(){
        return createResultDecision()
                .withResult(createResultForTest())
                .withDecision(true)
                .withDate(ZonedDateTime.now())
                .withUser(createUserForTest())
                .build();
    }
}
