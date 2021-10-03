package lv.aml.adversemediascreening.core.dto;

import lv.aml.adversemediascreening.searchengine.DateRestrict;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class SearchDTO {

    private Long id;
    private ZonedDateTime createdDate;
    private UserDTO user;
    private DateRestrict dateRestrict;
    private ClientDTO client;
    private List<KeywordDTO> keywords = new ArrayList<>();
    private Integer resultCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public DateRestrict getDateRestrict() {
        return dateRestrict;
    }

    public void setDateRestrict(DateRestrict dateRestrict) {
        this.dateRestrict = dateRestrict;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<KeywordDTO> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<KeywordDTO> keywords) {
        this.keywords = keywords;
    }

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }
}
