package co.simplon.controller.dto;

import co.simplon.enums.SectionEnum;
import co.simplon.model.JourneeEnfant;
import co.simplon.model.Section;
import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

@ApiModel("enfant")
public class EnfantDto {

    private Long id;
    private InfoEnfantDto enfantInfo;
    private List<ParentDto> geniteurs;
    private SectionEnum section;
    private String createdDate;
    private List<JourneeEnfant> journees = new ArrayList<>();

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

    public SectionEnum getSection() {
        return section;
    }

    public void setSection(SectionEnum section) {
        this.section = section;
    }

    public List<JourneeEnfant> getJournees() {
        return journees;
    }

    public void setJournees(List<JourneeEnfant> journees) {
        this.journees = journees;
    }
}
