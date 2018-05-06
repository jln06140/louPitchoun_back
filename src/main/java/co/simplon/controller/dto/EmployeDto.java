package co.simplon.controller.dto;

import co.simplon.enums.ProfilEnum;
import co.simplon.model.Profil;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;

@ApiModel("utilisateur employe")
public class EmployeDto {

    @NotNull
    private String login;

    @NotNull
    private String motDePasse;
    private boolean actif;
    private String createdDate;
    private String updatedDate;
    private ProfilEnum profil;
    private InfoEmployeDto infoEmploye;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
}
