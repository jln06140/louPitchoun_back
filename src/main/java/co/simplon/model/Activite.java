package co.simplon.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Activite {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalTime heureDebut;
	private LocalTime heureFin;
	private String remarque;
	
	@ManyToOne
	@JoinColumn( name = "id_type_activite")
	private TypeActivite typeActivite;
	
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

	public TypeActivite getTypeActivite() {
		return typeActivite;
	}

	public void setTypeActivite(TypeActivite typeActivite) {
		this.typeActivite = typeActivite;
	}
}
