package co.simplon.model;

import java.sql.Timestamp;

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
	
	private Timestamp heureDebut;
	private Timestamp heureFin;
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
	public Timestamp getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Timestamp heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Timestamp getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Timestamp heureFin) {
		this.heureFin = heureFin;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	
	
	
}
