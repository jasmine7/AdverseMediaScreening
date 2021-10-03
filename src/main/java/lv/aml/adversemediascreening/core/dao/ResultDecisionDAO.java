package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.ResultDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDecisionDAO extends JpaRepository<ResultDecision, Long> {

    @Query("select d from ResultDecision d JOIN FETCH d.user where d.result.id = (:resultId)")
    List<ResultDecision> findByResultIdAndFetchUserEagerly(@Param("resultId") Long resultId);
}
