package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SearchDAO extends JpaRepository<Search, Long> {

    @Modifying
    @Transactional
    @Query("update Search s set s.resultCount = :resultCount where s.id = :searchId")
    void setResultCount(@Param("searchId") Long id, @Param("resultCount") Integer resultCount);
}
