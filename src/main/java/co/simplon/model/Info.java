package co.simplon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table ( name = "Info")
@Inheritance ( strategy = InheritanceType.JOINED )
public abstract class Info {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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

	@Override
	public String toString() {
		return "Info{" +
				" nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				'}';
	}
}
