package co.simplon.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import co.simplon.enums.ProfilEnum;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.AUTO)
	private long id;
	
	@Column( unique = true)
	private String login;
	
	@Column( name = "mot_de_passe")
	private String motDePasse;
	private boolean actif;
	
	@CreatedDate
	private Date createDate;
	
	@ManyToOne
	@JoinColumn (name = "id_profil")
	private Profil profil;
		
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn ( name = "id_info")
	private CommonInfo commonInfo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "parent_enfant",
				joinColumns = {@JoinColumn(name = "parent_id")},
				inverseJoinColumns= {@JoinColumn(name = "enfant_id")})
	private Set<Enfant> enfants;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public CommonInfo getCommonInfo() {
		return commonInfo;
	}
	public void setCommonInfo(CommonInfo commonInfo) {
		this.commonInfo = commonInfo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isParent(){
		return this.profil.getLibelle().equals(ProfilEnum.PARENT.toString());
	}
	
	
	
	
	

}
