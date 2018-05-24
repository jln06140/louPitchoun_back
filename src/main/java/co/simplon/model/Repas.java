package co.simplon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Repas {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long id;

    private LocalTime heureDebut;
    private String repas;
    private String quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }
}
