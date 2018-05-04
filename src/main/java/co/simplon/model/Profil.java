package co.simplon.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.simplon.enums.ProfilEnum;

@Entity
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private ProfilEnum libelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProfilEnum getLibelle() {
        return libelle;
    }

    public void setLibelle(ProfilEnum libelle) {
        this.libelle = libelle;
    }
}
