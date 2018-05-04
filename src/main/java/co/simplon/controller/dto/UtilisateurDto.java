package co.simplon.controller.dto;

import co.simplon.enums.ProfilEnum;

public class UtilisateurDto {

    private String email;
    private String motDePasse;
    private ProfilEnum profil;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
}
