package co.simplon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table ( name = "parent_info" )
@PrimaryKeyJoinColumn (name = "id")
public class ParentInfo extends CommonInfo {

	@Column (name = "tel_pro")
	private String telPro;
	
	@Column (name = "tel_fixe")
	private String telFixe;
	
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
	
	
	
}
