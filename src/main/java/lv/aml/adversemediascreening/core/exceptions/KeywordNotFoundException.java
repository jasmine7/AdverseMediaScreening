package lv.aml.adversemediascreening.core.exceptions;

public class KeywordNotFoundException extends RuntimeException {

    public KeywordNotFoundException(Long id){
        super("Keyword with id " + id.toString() + " not found");
    }
}
