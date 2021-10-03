package lv.aml.adversemediascreening.core.commands.search;

import lv.aml.adversemediascreening.core.commands.DomainCommand;
import lv.aml.adversemediascreening.core.services.search.SearchSorting;
import org.springframework.data.domain.Sort;

public class GetAllSearchesCommand implements DomainCommand<GetAllSearchesResult> {

    private int page;
    private int size;
    private SearchSorting sorting;
    private Sort.Direction direction;

    public GetAllSearchesCommand(int page, int size, SearchSorting sorting, Sort.Direction direction) {
        this.page = page;
        this.size = size;
        this.sorting = sorting;
        this.direction = direction;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public SearchSorting getSorting() {
        return sorting;
    }

    public Sort.Direction getDirection() {
        return direction;
    }
}
