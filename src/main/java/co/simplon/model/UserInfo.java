package co.simplon.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn (name = "id")

//http://www.thejavageek.com/2014/05/14/jpa-single-table-inheritance-example/

public class UserInfo extends Info {
	
	private String adresse;
	private String ville;
	
	@Column(unique = true)
	private String email;
	
	@Column ( name = "tel_mobile")
	private String telMobile;

	@Column (name = "tel_pro")
	private String telPro;

	@Column (name = "tel_fixe")
	private String telFixe;

	private String fonction;
	private Date dateEmbauche;
	private String typeContrat;
	
	
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

	public String getTelPro() {
		return telPro;
	}

	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
}
