package co.simplon.controller.dto;

import co.simplon.enums.ProfilEnum;
import co.simplon.enums.SectionEnum;
import co.simplon.model.Profil;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;

@ApiModel("utilisateur employe")
public class EmployeDto {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String motDePasse;
    private boolean actif;
    private String createdDate;
    private String updatedDate;
    private ProfilEnum profil;
    private SectionEnum section;
    private InfoEmployeDto infoEmploye;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ProfilEnum getProfil() {
        return profil;
    }

    public void setProfil(ProfilEnum profil) {
        this.profil = profil;
    }

    public InfoEmployeDto getInfoEmploye() {
        return infoEmploye;
    }

    public void setInfoEmploye(InfoEmployeDto infoEmploye) {
        this.infoEmploye = infoEmploye;
    }

    public SectionEnum getSection() {
        return section;
    }

    public void setSection(SectionEnum section) {
        this.section = section;
    }
}
