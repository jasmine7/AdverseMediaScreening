package lv.aml.adversemediascreening.core.builders.keyword;

import lv.aml.adversemediascreening.core.dto.KeywordDTO;

public class KeywordDTOBuilder {

    private Long id;
    private String name;

    private KeywordDTOBuilder(){

    }

    public static KeywordDTOBuilder createKeywordDTO(){
        return new KeywordDTOBuilder();
    }

    public KeywordDTO build(){
        KeywordDTO keyword = new KeywordDTO();
        keyword.setId(id);
        keyword.setName(name);
        return keyword;
    }

    public KeywordDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public KeywordDTOBuilder withName(String name){
        this.name = name;
        return this;
    }
}
