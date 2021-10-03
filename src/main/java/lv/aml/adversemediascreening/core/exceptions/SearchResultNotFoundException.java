package lv.aml.adversemediascreening.core.exceptions;

public class SearchResultNotFoundException extends RuntimeException {

    public SearchResultNotFoundException(Long id) {
        super("Search result with id " + id.toString() + " not found");
    }
}
