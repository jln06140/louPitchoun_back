package co.simplon.controller.dto;

import co.simplon.enums.ProfilEnum;
import co.simplon.enums.SectionEnum;
import io.swagger.annotations.ApiModel;

@ApiModel("utilisateur")
public class UtilisateurDto {

    private Long id;
    private String username;
    private String motDePasse;
    private boolean actif;
    private ProfilEnum profil;
    private SectionEnum section;
    private InfoUserDto infoUserDto;
    private String createdDate;
    private String updatedDate;



    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public ProfilEnum getProfil() {
        return profil;
    }

    public void setProfil(ProfilEnum profil) {
        this.profil = profil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public InfoUserDto getInfoUserDto() {
        return infoUserDto;
    }

    public void setInfoUserDto(InfoUserDto infoUserDto) {
        this.infoUserDto = infoUserDto;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
