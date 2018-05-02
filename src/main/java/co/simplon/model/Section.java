package co.simplon.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import co.simplon.enums.SectionEnum;

@Entity
public class Section {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private SectionEnum nom;
	
	private String email;
	private String annee;
	
	@OneToMany
	@JoinColumn ( name = "id_employe")
	private Set<Utilisateur> employes;
	
	@OneToMany
	@JoinColumn ( name = "id_enfant")
	private Set<Enfant> enfants;

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

	public Set<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Enfant> enfants) {
		this.enfants = enfants;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Utilisateur> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Utilisateur> employes) {
		this.employes = employes;
	}
	
	
}
