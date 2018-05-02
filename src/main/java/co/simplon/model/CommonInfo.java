package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "common_info")
@PrimaryKeyJoinColumn (name = "id")
@Inheritance ( strategy = InheritanceType.JOINED )
public abstract class CommonInfo extends info {
	
	private String adresse;
	private String ville;
	
	@Column(unique = true)
	private String email;
	
	@Column ( name = "tel_mobile")
	private String telMobile;
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelMobile() {
		return telMobile;
	}
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	
	
}
