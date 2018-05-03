package co.simplon.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table (name = "common_info")
@MappedSuperclass

http://www.thejavageek.com/2014/05/14/jpa-single-table-inheritance-example/

public class CommonInfo extends info {
	
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
