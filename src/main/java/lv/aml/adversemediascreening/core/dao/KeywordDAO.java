package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.Keyword;
import lv.aml.adversemediascreening.core.dto.KeywordDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordDAO extends JpaRepository<Keyword, Long> {

    @Query("select new lv.aml.adversemediascreening.core.dto.KeywordDTO(k.id, k.name) from Keyword k")
    List<KeywordDTO> getAllKeywordDTOs();
}
