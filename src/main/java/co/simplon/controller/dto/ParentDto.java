package co.simplon.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import co.simplon.model.Info;

import co.simplon.model.Profil;
import co.simplon.model.UserInfo;
import io.swagger.annotations.ApiModel;

@ApiModel("utilisateur parent")
public class ParentDto {

	@NotNull
	private String login;
	
	@NotNull
	private String motDePasse;
	private Date createDate;
	private Profil profil;
	private UserInfo info;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}
}
