package lv.aml.adversemediascreening.searchengine;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomSearchEngineTest {

    @Test
    public void doSearchTest(){
        DateRestrict dateRestrict = DateRestrict.YEAR;
        String exactTerms = "Transact Pro";
        String query = "fraud OR court";
        CustomSearchEngine engine = new CustomSearchEngine();

        List<CustomSearchItem> items = engine.doSearch(dateRestrict, exactTerms, query);
        assertNotEquals(0, items.size());
    }

}