package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "parent")
@PrimaryKeyJoinColumn (name = "id")
public class Parent extends Utilisateur {
	
	private String email;
	private String adresse;
	private String adressePro;
	
	@Column(name = "telephoneFixe")
	private String telFixe;
	
	@Column(name = "telephoneMobile")
	private String telMobile;
	
	@Column(name = "telephonePro")
	private String telPro;
	


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdressePro() {
		return adressePro;
	}
	public void setAdressePro(String adressePro) {
		this.adressePro = adressePro;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	public String getTelMobile() {
		return telMobile;
	}
	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}
	public String getTelPro() {
		return telPro;
	}
	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	
	
}
