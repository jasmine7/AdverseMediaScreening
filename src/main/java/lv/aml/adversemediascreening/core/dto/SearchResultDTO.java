package lv.aml.adversemediascreening.core.dto;

public class SearchResultDTO {

    private Long id;
    private String title;
    private String link;
    private String snippet;
    private ResultDecisionDTO decision;

    public SearchResultDTO() {
    }

    public SearchResultDTO(Long id, String title, String link, String snippet) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.snippet = snippet;
    }

    public SearchResultDTO(Long id, String title, String link, String snippet, ResultDecisionDTO decision) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.snippet = snippet;
        this.decision = decision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public ResultDecisionDTO getDecision() {
        return decision;
    }

    public void setDecision(ResultDecisionDTO decision) {
        this.decision = decision;
    }
}
