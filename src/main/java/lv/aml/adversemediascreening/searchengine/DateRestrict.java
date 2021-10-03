package lv.aml.adversemediascreening.searchengine;

public enum DateRestrict {

    DAY("d1"),
    WEEK("m1"),
    MONTH("m1"),
    YEAR("y1"),
    ALL_TIME("at");

    private final String value;

    DateRestrict(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
