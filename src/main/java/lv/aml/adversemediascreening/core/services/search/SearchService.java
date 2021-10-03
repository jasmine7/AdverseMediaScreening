package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.domain.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface SearchService {

    Search getById(Long id);

    Page<Search> getAll(int page, int size, SearchSorting sorting, Sort.Direction direction);
}
