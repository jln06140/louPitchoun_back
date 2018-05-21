package co.simplon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class JourneeEnfant {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate date;
	private LocalTime heureArrivee;
	private LocalTime heureDepart;
	private String remarque;
	private boolean journeeEnCours = false;

	@ManyToOne
	@JsonBackReference
	@JoinColumn (name="id_enfant")
	private Enfant enfant;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn ( name = "id_activite")
	private List<Activite> activites = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public LocalTime getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(LocalTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public boolean isJourneeEnCours() {
		return journeeEnCours;
	}

	public void setJourneeEnCours(boolean journeeEnCours) {
		this.journeeEnCours = journeeEnCours;
	}
}
