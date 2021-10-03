package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.SearchResult;
import lv.aml.adversemediascreening.core.dto.SearchResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface SearchResultDAO extends JpaRepository<SearchResult, Long> {

    @Query("select " +
            "new lv.aml.adversemediascreening.core.dto.SearchResultDTO(r.id, r.title, r.link, r.snippet) " +
            "from SearchResult r where r.search.id = :searchId")
    List<SearchResultDTO> getAllResultsBySearchId(@Param("searchId") Long searchId);

    @Query(value = "select * from search_results r " +
            "left join (select id as decision_id, result_id, decision, date, user_id, username, first_name, last_name " +
            "from decisions_history h " +
            "left join (select id as user_id, username, first_name, last_name from users) u using (user_id) " +
            "where (h.result_id, h.date) in (select result_id, max(date) " +
            "from decisions_history group by result_id)) d on d.result_id = r.id " +
            "where search_id = :searchId " +
            "order by id asc", nativeQuery = true)
    List<Tuple> getAllResultsWithDecisionsBySearchId(@Param("searchId") Long searchId);
}
