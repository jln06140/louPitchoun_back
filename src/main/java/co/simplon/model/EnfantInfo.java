package co.simplon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn (name = "id")
public class EnfantInfo extends Info {

	@Column( name = "date_de_naissance")
	private Date dateDeNaissance;
	private boolean allergie;
	private boolean maladie;
	private boolean biberon;
	
	
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateNaissance) {
		this.dateDeNaissance = dateNaissance;
	}

	public boolean isAllergie() {
		return allergie;
	}

	public void setAllergie(boolean allergie) {
		this.allergie = allergie;
	}

	public boolean isMaladie() {
		return maladie;
	}

	public void setMaladie(boolean maladie) {
		this.maladie = maladie;
	}

	public boolean isBiberon() {
		return biberon;
	}
	public void setBiberon(boolean biberon) {
		this.biberon = biberon;
	}

	
	

}
