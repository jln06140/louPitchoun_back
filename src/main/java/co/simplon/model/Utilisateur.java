package co.simplon.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	protected Long id;
	
	protected String nom;
	protected String prenom;
	
	@Column(name = "datedenaissance")
	protected Date dateDeNaissance;
	
	@ManyToOne
	@JoinColumn(name="idLogin")
	protected Login login;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	

}
