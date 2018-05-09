package co.simplon.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import co.simplon.enums.ProfilEnum;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column
    private boolean actif;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_profil")
    private Profil profil;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_info")
    private UserInfo info;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parent_enfant",
            joinColumns = {@JoinColumn(name = "parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "enfant_id")})
    private Set<Enfant> enfants;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public Set<Enfant> getEnfants() {
        return enfants;
    }

    public void setEnfants(Set<Enfant> enfants) {
        this.enfants = enfants;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isParent() {
        return this.profil.getLibelle().equals(ProfilEnum.PARENT.toString());
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
