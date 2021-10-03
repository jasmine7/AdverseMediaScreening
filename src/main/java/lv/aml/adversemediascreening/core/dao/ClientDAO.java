package lv.aml.adversemediascreening.core.dao;

import lv.aml.adversemediascreening.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientDAO extends JpaRepository<Client, Long> {

    @Query(value = "select * from clients where concat(id, ' ', name, ' ' , type) " +
            "like %:searchCriteria% limit 5",
            nativeQuery = true)
    List<Client> getFirstFiveClientsBySearchCriteria(@Param("searchCriteria") String searchCriteria);

}
