package co.simplon.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * Modele representant un employe de la creche
 *
 */

@Entity
@Table (name = "employe")
@PrimaryKeyJoinColumn( name = "id")
public class Employe extends Utilisateur {
	
	
	private String fonction;
	private String grade;
	
	@Column(name = "datecontrat")
	private Date dateDebutContrat;
	
	@Column(name = "typecontrat")
	private String typeContrat;
	
	@ManyToOne
	@JoinColumn(name="idProfil")
	private Profil profil;
	

	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}
	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	
	

}
