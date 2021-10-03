package lv.aml.adversemediascreening.searchengine;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomSearchEngine {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSearchEngine.class);

    private static final String URL = "https://customsearch.googleapis.com/customsearch/v1?";
    private static final String KEY = "****";
    private static final String CX = "****";
    private static final String FIELDS = "queries/nextPage/startIndex,items(title,link,snippet)";

    private String startIndex;

    public List<CustomSearchItem> doSearch(DateRestrict dateRestrict, String exactTerms, String query) {
        RestTemplate restTemplate = new RestTemplate();
        List<CustomSearchItem> results = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        startIndex = "1";

        while(!startIndex.equals("0")){
            ResponseEntity<String> responseEntity = restTemplate
                    .getForEntity(createURI(dateRestrict, exactTerms, query),
                            String.class);
            String responseToParse = responseEntity.getBody();
            try {
                JsonNode rootNode = mapper.readTree(responseToParse);

                JsonNode queries = rootNode.get("queries");
                if(queries.has("nextPage")){
                    startIndex = queries.at("/nextPage/0/startIndex").asText();
                } else {
                    startIndex = "0";
                }

                if(rootNode.has("items")){
                    JsonNode itemsNode = rootNode.get("items");
                    List<CustomSearchItem> items = mapper
                            .readerFor(new TypeReference<List<CustomSearchItem>>(){})
                            .readValue(itemsNode);
                    results.addAll(items);
                }

                if(startIndex.equals("31")){
                    break;
                }
            } catch (IOException e){
                e.printStackTrace();
                break;
            }

        }
        return results;
    }

    private String createURI(DateRestrict dateRestrict, String exactTerms, String query){
        String uri = URL
                +"key="+KEY
                +"&cx="+CX
                +"&fields="+FIELDS
                +"&start="+startIndex
                +"&exactTerms="+exactTerms
                +"&q="+query;
        if(dateRestrict != DateRestrict.ALL_TIME){
            uri = uri + "&dateRestrict="+dateRestrict.getValue();
        }
        LOGGER.info("Search URI: " + uri);
        return uri;
    }
}
