package co.simplon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import co.simplon.enums.SectionEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Section {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private SectionEnum nom;
	
	private String email;
	private String annee;
	
	@OneToMany(mappedBy = "section")
	@JsonManagedReference
	private List<Utilisateur> employes = new ArrayList<>();
	
	@OneToMany(mappedBy="section",
			cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Enfant> enfants = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SectionEnum getNom() {
		return nom;
	}

	public void setNom(SectionEnum nom) {
		this.nom = nom;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Utilisateur> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Utilisateur> employes) {

		this.employes = employes;
	}

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
}
