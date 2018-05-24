package co.simplon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class Sieste {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private boolean siesteEnCours = false;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String remarque;

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

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public boolean isSiesteEnCours() {
        return siesteEnCours;
    }

    public void setSiesteEnCours(boolean siesteEnCours) {
        this.siesteEnCours = siesteEnCours;
    }
}
