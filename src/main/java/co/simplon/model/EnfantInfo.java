package co.simplon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table ( name = " enfant_info")
@PrimaryKeyJoinColumn (name = "id")
public class EnfantInfo extends info{
	
	@Column( name = "date_de_naissance")
	private Date dateNaissance;
	private String allergie;
	private String maladie;
	private boolean biberon;
	
	
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
