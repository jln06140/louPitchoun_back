package co.simplon.controller.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("enfant")
public class EnfantDto {

    private Long id;
    private InfoEnfantDto enfantInfo;
    private List<ParentDto> geniteurs;
    private String createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InfoEnfantDto getEnfantInfo() {
        return enfantInfo;
    }

    public void setEnfantInfo(InfoEnfantDto enfantInfo) {
        this.enfantInfo = enfantInfo;
    }

    public List<ParentDto> getGeniteurs() {
        return geniteurs;
    }

    public void setGeniteurs(List<ParentDto> geniteurs) {
        this.geniteurs = geniteurs;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
