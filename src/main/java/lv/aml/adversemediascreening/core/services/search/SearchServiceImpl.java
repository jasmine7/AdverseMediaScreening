package lv.aml.adversemediascreening.core.services.search;

import lv.aml.adversemediascreening.core.dao.SearchDAO;
import lv.aml.adversemediascreening.core.domain.Search;
import lv.aml.adversemediascreening.core.exceptions.SearchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final SearchDAO searchDAO;

    @Autowired
    public SearchServiceImpl(SearchDAO searchDAO){
        this.searchDAO = searchDAO;
    }

    @Override
    public Search getById(Long id) {
        return searchDAO.findById(id).orElseThrow(()-> new SearchNotFoundException(id));
    }

    @Override
    public Page<Search> getAll(int page, int size, SearchSorting sorting, Sort.Direction direction) {
        List<Sort.Order> orders = new ArrayList<>();

        switch (sorting){
            case ID:
                orders.add(new Sort.Order(direction, "id"));
                break;
            case CREATED_DATE:
                orders.add(new Sort.Order(direction, "createdDate"));
                break;
            case DATE_RESTRICT:
                orders.add(new Sort.Order(direction, "dateRestrict"));
                orders.add(new Sort.Order(Sort.Direction.DESC, "createdDate"));
                break;
            case USER:
                orders.add(new Sort.Order(direction, "user.lastName"));
                orders.add(new Sort.Order(Sort.Direction.ASC, "user.firstName"));
                orders.add(new Sort.Order(Sort.Direction.DESC, "createdDate"));
                break;
            case CLIENT:
                orders.add(new Sort.Order(direction, "client.name"));
                orders.add(new Sort.Order(Sort.Direction.ASC, "client.type"));
                orders.add(new Sort.Order(Sort.Direction.DESC, "createdDate"));
                break;
            case RESULT_COUNT:
                orders.add(new Sort.Order(direction, "resultCount"));
                orders.add(new Sort.Order(Sort.Direction.DESC, "createdDate"));
            default:
                orders.add(new Sort.Order(Sort.Direction.DESC, "createdDate"));
        }

        Pageable requestedPage = PageRequest.of(page, size, Sort.by(orders));

        return searchDAO.findAll(requestedPage);
    }

}
