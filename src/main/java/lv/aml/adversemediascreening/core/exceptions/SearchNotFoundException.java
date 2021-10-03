package lv.aml.adversemediascreening.core.exceptions;

public class SearchNotFoundException extends RuntimeException {

    public SearchNotFoundException(Long id){
        super("Search with id " + id.toString() + " not found");
    }
}
