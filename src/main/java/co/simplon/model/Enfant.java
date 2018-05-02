package co.simplon.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Enfant {

	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;
	@Column( name = "date_de_naissance")
	private Date dateNaissance;
	private String allergie;
	private String maladie;
	private boolean biberon;
	
	@ManyToMany( mappedBy = "enfants")
	private Set<Utilisateur> parents;
	
	@OneToOne
	@MapsId
	@JoinColumn ( name = "id_enfant_info")
	private EnfantInfo enfantInfo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public EnfantInfo getEnfantInfo() {
		return enfantInfo;
	}
	public void setEnfantInfo(EnfantInfo enfantInfo) {
		this.enfantInfo = enfantInfo;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAllergie() {
		return allergie;
	}
	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	public String getMaladie() {
		return maladie;
	}
	public void setMaladie(String maladie) {
		this.maladie = maladie;
	}
	public boolean isBiberon() {
		return biberon;
	}
	public void setBiberon(boolean biberon) {
		this.biberon = biberon;
	}
	
	
	
}
