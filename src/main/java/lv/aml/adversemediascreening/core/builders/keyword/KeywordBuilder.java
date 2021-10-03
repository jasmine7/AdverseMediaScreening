package lv.aml.adversemediascreening.core.builders.keyword;

import lv.aml.adversemediascreening.core.domain.Keyword;

public class KeywordBuilder {

    private Long id;
    private String name;

    private KeywordBuilder(){

    }

    public static KeywordBuilder createKeyword(){
        return new KeywordBuilder();
    }

    public Keyword build(){
        Keyword keyword = new Keyword();
        keyword.setId(id);
        keyword.setName(name);
        return keyword;
    }

    public KeywordBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public KeywordBuilder withName(String name){
        this.name = name;
        return this;
    }
}
