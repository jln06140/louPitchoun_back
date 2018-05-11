package co.simplon.controller.dto;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("information d'un enfant")
public class InfoEnfantDto {

    private Long id;
    private Date dateDeNaissance;
    private boolean allergie;
    private boolean maladie;
    private boolean biberon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public boolean isAllergie() {
        return allergie;
    }

    public void setAllergie(boolean allergie) {
        this.allergie = allergie;
    }

    public boolean isMaladie() {
        return maladie;
    }

    public void setMaladie(boolean maladie) {
        this.maladie = maladie;
    }

    public boolean isBiberon() {
        return biberon;
    }

    public void setBiberon(boolean biberon) {
        this.biberon = biberon;
    }
}
