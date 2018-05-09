package co.simplon.controller.dto;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import co.simplon.enums.ProfilEnum;
import co.simplon.model.Enfant;
import co.simplon.model.Info;

import co.simplon.model.Profil;
import co.simplon.model.UserInfo;
import io.swagger.annotations.ApiModel;

@ApiModel("utilisateur parent")
public class ParentDto {

	private Long id;
	@NotNull
	private String username;

	@NotNull
	private String motDePasse;
	private boolean actif;
	private String createdDate;
	private String updatedDate;
	private ProfilEnum profil;
	private InfoParentDto infoParent;
	private Set<Enfant> enfants;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public ProfilEnum getProfil() {
		return profil;
	}

	public void setProfil(ProfilEnum profil) {
		this.profil = profil;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Set<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(Set<Enfant> enfants) {
		this.enfants = enfants;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public InfoParentDto getInfoParent() {
		return infoParent;
	}

	public void setInfoParent(InfoParentDto infoParent) {
		this.infoParent = infoParent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
